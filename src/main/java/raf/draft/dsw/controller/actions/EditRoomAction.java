package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class EditRoomAction extends AbstactRoomAction {

    public EditRoomAction() {
        putValue(SMALL_ICON, loadIcon("/images/interior-design.png"));
        putValue(NAME, "Edit Room");
        putValue(SHORT_DESCRIPTION, "Edit Room");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponente = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponente.startEditRoomState();
    }
}
