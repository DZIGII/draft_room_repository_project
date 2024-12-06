package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class ZoomState extends AbstactRoomAction implements State {

    public ZoomState() {
        putValue(SMALL_ICON, loadIcon("/images/loupe.png"));
        putValue(NAME, "Zoom");
        putValue(SHORT_DESCRIPTION, "Zoom");
    }

    @Override
    public void log() {
        System.out.println("Zoom State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setZoomState();
    }
}
