package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.gui.swing.tree.DraftTreeImplementation;
import raf.draft.dsw.gui.swing.tree.controller.DoubleClickListener;
import raf.draft.dsw.model.DraftRoomExplorerImplementation;
import raf.draft.dsw.model.repository.DraftRoomRepository;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame{
    //buduca polja za sve komponente view-a na glavnom prozoru

    private ActionManager actionManager;
    private DraftTreeImplementation draftTree;
    private DraftRoomRepository draftRoomRepository;
    private JTabbedPane tabFrame;

    private static MainFrame instance;

    private MainFrame(){
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
            instance.initialize();
        }
        return instance;
    }

    private void initialize(){
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

        MyToolBar toolBar = new MyToolBar(actionManager);
        add(toolBar, BorderLayout.NORTH);

        draftRoomRepository = new DraftRoomExplorerImplementation();
        JTree projectExplorer = draftTree.generateTree(draftRoomRepository.getRoot());
        projectExplorer.addMouseListener(new DoubleClickListener());
        JPanel desktop = new JPanel();

        JScrollPane scroll=new JScrollPane(projectExplorer);
        scroll.setMinimumSize(new Dimension(200,150));
        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
        getContentPane().add(split,BorderLayout.WEST);
        split.setDividerLocation(250);
        split.setOneTouchExpandable(true);

        tabFrame = new JTabbedPane();
        add(tabFrame, BorderLayout.CENTER);
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

    //    public void setTabFrame(JTabbedPane tabFrame) {
//        tabPanel.removeAll();
//        tabPanel.add(tabFrame, BorderLayout.CENTER);
//        tabPanel.revalidate();
//        tabPanel.repaint();
//    }


//    Vidi za Implementiranje ISubsribera na MainFrame
//implements ISubscriber



//    @Override
//    public void recive(Message message) {
//        JOptionPane.showMessageDialog(null, message.toString(), "Notification", JOptionPane.INFORMATION_MESSAGE);
//    }
}
