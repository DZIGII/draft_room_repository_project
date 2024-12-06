package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class MoveAction extends AbstactRoomAction {

    public MoveAction() {
        putValue(SMALL_ICON, loadIcon("/images/two.png"));
        putValue(NAME, "Move");
        putValue(SHORT_DESCRIPTION, "Move");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponent.startMoveState();
    }
}
