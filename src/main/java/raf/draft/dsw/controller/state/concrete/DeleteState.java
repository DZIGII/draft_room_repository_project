package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class DeleteState extends AbstactRoomAction implements State {

    public DeleteState() {
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void log() {
        System.out.println("Delete State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setDeleteState();
    }
}
