package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.messagegenerator.ConsoleLogger;
import raf.draft.dsw.controller.messagegenerator.FileLogger;
import raf.draft.dsw.controller.messagegenerator.LoggerFactory;
import raf.draft.dsw.controller.messagegenerator.MessageGenerator;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.tree.DraftTreeImplementation;
import raf.draft.dsw.gui.swing.tree.controller.DoubleClickListener;
import raf.draft.dsw.model.DraftRoomExplorerImplementation;
import raf.draft.dsw.model.messages.Message;

import raf.draft.dsw.model.repository.DraftRoomRepository;


import javax.swing.*;
import java.awt.*;


public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru

    private ActionManager actionManager;
    private DraftTreeImplementation draftTree;
    private DraftRoomRepository draftRoomRepository;
    private JTabbedPane tabFrame;
    private Label infoLabel = new Label("-------------");
    private MessageGenerator messageGenerator;
    private LoggerFactory loggerFactory;
    private StateToolBar stateToolBar;
    private static MainFrame instance;

    private MainFrame() {
    }

    public static MainFrame getInstance() {
        if (instance == null) {
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

    private void initialize() {
        actionManager = new ActionManager();
        draftTree = new DraftTreeImplementation();
        stateToolBar = new StateToolBar(actionManager);

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("DraftRoom");

        MyMenuBar menu = new MyMenuBar();
        setJMenuBar(menu);

        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        MyToolBar toolBar = new MyToolBar(actionManager);
        topPanel.add(toolBar);
        topPanel.add(infoLabel);
        add(topPanel, BorderLayout.NORTH);

        draftRoomRepository = new DraftRoomExplorerImplementation();
        JTree projectExplorer = draftTree.generateTree(draftRoomRepository.getRoot());
        projectExplorer.addMouseListener(new DoubleClickListener());
        JPanel desktop = new JPanel();

        JScrollPane scroll = new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200, 150));
        JSplitPane split = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, scroll, desktop);
        getContentPane().add(split, BorderLayout.WEST);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

        JPanel tabWrapper = new JPanel();
        tabWrapper.setLayout(new BorderLayout());

        tabFrame = new JTabbedPane();

        tabFrame.setPreferredSize(new Dimension(500, 500));
        tabWrapper.add(tabFrame, BorderLayout.CENTER);
        add(tabFrame, BorderLayout.CENTER);
        add(stateToolBar, BorderLayout.EAST);

        messageGenerator = new MessageGenerator();
        loggerFactory = new LoggerFactory();
        ConsoleLogger cl = (ConsoleLogger) loggerFactory.createLogger("CONSOLE");
        FileLogger fl = (FileLogger)loggerFactory.createLogger("FILE");

        messageGenerator.subscribe(this);
        messageGenerator.subscribe(cl);
        //messageGenerator.subscribe(fl);

        //add(infoLabel, BorderLayout.EAST);
    }

    public ActionManager getActionManager() {
        return actionManager;
    }

    public void setActionManager(ActionManager actionManager) {
        this.actionManager = actionManager;
    }

    public DraftTreeImplementation getDraftTree() {
        return draftTree;
    }

    public void setDraftTree(DraftTreeImplementation draftTree) {
        this.draftTree = draftTree;
    }

    public DraftRoomRepository getDraftRoomRepository() {
        return draftRoomRepository;
    }

    public void setDraftRoomRepository(DraftRoomRepository draftRoomRepository) {
        this.draftRoomRepository = draftRoomRepository;
    }

    public MessageGenerator getMessageGenerator() {
        return messageGenerator;
    }

    public void setMessageGenerator(MessageGenerator messageGenerator) {
        this.messageGenerator = messageGenerator;
    }

    public JTabbedPane getTabFrame() {
        return tabFrame;
    }

    public void setTabFrame(JTabbedPane tabFrame) {
        this.tabFrame = tabFrame;
    }

    public static void setInstance(MainFrame instance) {
        MainFrame.instance = instance;
    }

    public Label getInfoLabel() {
        return infoLabel;
    }

    public void setInfoLabel(Label infoLabel) {
        this.infoLabel = infoLabel;
    }

    public StateToolBar getStateToolBar() {
        return stateToolBar;
    }

    public void setStateToolBar(StateToolBar stateToolBar) {
        this.stateToolBar = stateToolBar;
    }

    public LoggerFactory getLoggerFactory() {
        return loggerFactory;
    }

    public void setLoggerFactory(LoggerFactory loggerFactory) {
        this.loggerFactory = loggerFactory;
    }

    @Override
    public void recive(Object notification) {
        if (notification instanceof String) {
            infoLabel.setText((String) notification);
        }
    }



    @Override
    public void nodeDeleted() {
        infoLabel.setText("-------------");
    }

    @Override
    public void nodeAdded() {
        infoLabel.setText("Node added");
    }

    @Override
    public void update(Message message) {
        if(message.getMessageType().equalsIgnoreCase("ERROR")) {
            JOptionPane.showMessageDialog(this, message.toString(), "ERROR", JOptionPane.ERROR_MESSAGE);
        }
        else if(message.getMessageType().equalsIgnoreCase("WARNING")){
            JOptionPane.showMessageDialog(this, message.toString(), "WARNING", JOptionPane.WARNING_MESSAGE);
        }
        else if(message.getMessageType().equalsIgnoreCase("INFORMATION")) {
            JOptionPane.showMessageDialog(this, message.toString(), "INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}