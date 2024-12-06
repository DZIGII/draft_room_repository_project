package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class RotateAction extends AbstactRoomAction {

    public RotateAction() {
        putValue(SMALL_ICON, loadIcon("/images/rotate.png"));
        putValue(NAME, "Rotate");
        putValue(SHORT_DESCRIPTION, "Rotate");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponent.startRotateState();
    }
}
