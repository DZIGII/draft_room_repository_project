package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class EditAction extends AbstactRoomAction {

    public EditAction() {
        putValue(SMALL_ICON, loadIcon("/images/edit-icon.png"));
        putValue(NAME, "Edit");
        putValue(SHORT_DESCRIPTION, "Edit");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponent.startEditState();
    }
}
