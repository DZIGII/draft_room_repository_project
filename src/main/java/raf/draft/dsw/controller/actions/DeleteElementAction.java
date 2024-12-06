package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class DeleteElementAction extends AbstactRoomAction {

    public DeleteElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete");
        putValue(SHORT_DESCRIPTION, "Delete");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponente = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponente.startDeleteState();
    }
}
