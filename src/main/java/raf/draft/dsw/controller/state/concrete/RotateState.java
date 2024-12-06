package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class RotateState extends AbstactRoomAction implements State {

    public RotateState() {
        putValue(SMALL_ICON, loadIcon("/images/rotate.png"));
        putValue(NAME, "Rotate");
        putValue(SHORT_DESCRIPTION, "Rotate");
    }

    @Override
    public void log() {
        System.out.println("Rotete state");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setResizeState();
    }
}
