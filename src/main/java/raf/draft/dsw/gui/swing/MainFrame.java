package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.gui.swing.tree.DraftTree;
import raf.draft.dsw.gui.swing.tree.DraftTreeImplementation;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {
    //buduca polja za sve komponente view-a na glavnom prozoru

    private ActionManager actionManager;
    private DraftTree draftTree;

    private static MainFrame instance;

    private MainFrame(){
        initialize();
    }

    public static MainFrame getInstance(){
        if(instance == null){
            instance = new MainFrame();
        }
        return instance;
    }

    private void initialize(){
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

        actionManager = new ActionManager();

        MyToolBar toolBar = new MyToolBar(actionManager);
        add(toolBar, BorderLayout.NORTH);

        draftTree = new DraftTreeImplementation();

//        JTree projectExplorer = draftTree.generateTree(ApplicationFramework.getInstance().);
//        JPanel desktop = new JPanel();
//
//        JScrollPane scroll=new JScrollPane(projectExplorer);
//        scroll.setMinimumSize(new Dimension(200,150));
//        JSplitPane split=new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,scroll,desktop);
//        getContentPane().add(split,BorderLayout.CENTER);
//        split.setDividerLocation(250);
//        split.setOneTouchExpandable(true);

    }

    public DraftTree getDraftTree() {
        return draftTree;
    }

    public void setDraftTree(DraftTree draftTree) {
        this.draftTree = draftTree;
    }
}
