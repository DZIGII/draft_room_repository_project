package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class EditRoomState extends AbstactRoomAction implements State {

    public EditRoomState() {
        putValue(SMALL_ICON, loadIcon("/images/interior-design.png"));
        putValue(NAME, "Edit Room");
        putValue(SHORT_DESCRIPTION, "Edit Room");
    }

    @Override
    public void log() {
        System.out.println("Edit Room State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setEditRoomState();
    }
}
