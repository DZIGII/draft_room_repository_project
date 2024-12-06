package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class ResizeAction extends AbstactRoomAction {

    public ResizeAction() {
        putValue(SMALL_ICON, loadIcon("/images/resize.png"));
        putValue(NAME, "Resize");
        putValue(SHORT_DESCRIPTION, "Resize");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponent.startResizeState();
    }
}
