package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.state.StateManager;

import javax.swing.*;

public class StateToolBar extends JToolBar {
    public StateToolBar(StateManager sm) {
        super(VERTICAL);

        add(sm.getEditRoomState());
        add(sm.getAddElementState());
        add(sm.getSelectState());
        add(sm.getResizeState());
        add(sm.getCopyPasteState());
        add(sm.getMoveState());
        add(sm.getZoomState());
        add(sm.getEditState());
        add(sm.getDeleteState());

    }
}
