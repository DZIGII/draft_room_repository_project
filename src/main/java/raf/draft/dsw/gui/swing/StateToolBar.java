package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ActionManager;

import javax.swing.*;

public class StateToolBar extends JToolBar {
    public StateToolBar(ActionManager am) {
        super(VERTICAL);

        add(am.getEditRoomAction());
        add(am.getAddElementAction());
        add(am.getSelectAction());
        add(am.getResizeAction());
        add(am.getCopyPasteAction());
        add(am.getMoveAction());
        add(am.getZoomAction());
        add(am.getEditAction());
        add(am.getDeleteElementAction());

    }
}
