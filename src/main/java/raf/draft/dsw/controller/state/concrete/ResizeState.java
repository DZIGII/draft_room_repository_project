package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class ResizeState extends AbstactRoomAction implements State {

    public ResizeState() {
        putValue(SMALL_ICON, loadIcon("/images/resize.png"));
        putValue(NAME, "Resize");
        putValue(SHORT_DESCRIPTION, "Resize");
    }

    @Override
    public void log() {
        System.out.println("Resize State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setResizeState();
    }
}
