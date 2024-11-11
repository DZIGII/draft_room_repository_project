package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.tree.DraftTreeImplementation;
import raf.draft.dsw.gui.swing.tree.controller.DoubleClickListener;
import raf.draft.dsw.model.DraftRoomExplorerImplementation;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.repository.DraftRoomRepository;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame implements ISubscriber {
    //buduca polja za sve komponente view-a na glavnom prozoru

    private ActionManager actionManager;
    private DraftTreeImplementation draftTree;
    private DraftRoomRepository draftRoomRepository;
    private JTabbedPane tabFrame;
    private Label infoLabel = new Label("-------------");

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

        tabFrame = new JTabbedPane();
        add(tabFrame, BorderLayout.CENTER);

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

    public JTabbedPane getTabFrame() {
        return tabFrame;
    }

    public void setTabFrame(JTabbedPane tabFrame) {
        this.tabFrame = tabFrame;
    }

    public static void setInstance(MainFrame instance) {
        MainFrame.instance = instance;
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



    //    public void setTabFrame(JTabbedPane tabFrame) {
//        tabPanel.removeAll();
//        tabPanel.add(tabFrame, BorderLayout.CENTER);
//        tabPanel.revalidate();
//        tabPanel.repaint();
//    }
}