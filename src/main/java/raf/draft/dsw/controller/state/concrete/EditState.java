package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class EditState extends AbstactRoomAction implements State {

    public EditState() {
        putValue(SMALL_ICON, loadIcon("/images/edit-icon.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void log() {
        System.out.println("Edit State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setEditState();
    }
}
