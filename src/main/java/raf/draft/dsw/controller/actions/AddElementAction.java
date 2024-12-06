package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class AddElementAction extends AbstactRoomAction {

    public AddElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/add-state.png"));
        putValue(NAME, "Add Element");
        putValue(SHORT_DESCRIPTION, "Add Element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponent.startAddElemetState();
    }
}
