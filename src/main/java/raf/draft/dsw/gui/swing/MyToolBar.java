package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.actions.NewProjectAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(ActionManager am){
        super(HORIZONTAL);
        setFloatable(false);

        add(MainFrame.getInstance().getActionManager().getExitAction());
        add(new NewProjectAction());
//        add(MainFrame.getInstance().getActionManager().getExitAction());
//        add (MainFrame.getInstance().getActionManager().getNewProjectAction());
    }
}
