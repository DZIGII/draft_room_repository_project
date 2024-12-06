package raf.draft.dsw.controller.state.concrete;

import com.sun.tools.javac.Main;
import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class MoveState extends AbstactRoomAction implements State {

    public MoveState() {
        putValue(SMALL_ICON, loadIcon("/images/two.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }

    @Override
    public void log() {
        System.out.println("Move State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setMoveState();
    }
}
