package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class SelectState extends AbstactRoomAction implements State {

    public SelectState() {
        putValue(SMALL_ICON, loadIcon("/images/select.png"));
        putValue(NAME, "Select");
        putValue(SHORT_DESCRIPTION, "Select");
    }

    @Override
    public void log() {
        System.out.println("Select state");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setSelectState();
    }
}
