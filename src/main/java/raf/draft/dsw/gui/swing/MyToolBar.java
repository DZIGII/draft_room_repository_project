package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.ActionManager;
import raf.draft.dsw.controller.actions.NewProjectAction;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(ActionManager am){
        super(HORIZONTAL);
        setFloatable(false);

        add(am.getExitAction());
        add(am.getNewProjectAction());
        add(am.getRenameAction());
        add(am.getDeleteNodeAction());
        add(am.getEditProjectAction());
        add(am.getUndoAction());
        add(am.getRedoAction());
        add(am.getSaveAction());
        add(am.getSaveAsAction());
        add(am.getOpenProjectAction());
        add(am.getOrganizeMyRoomAction());
        add(am.getTemplateMenuAction());
    }
}
