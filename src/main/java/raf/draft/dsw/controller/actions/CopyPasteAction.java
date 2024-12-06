package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.ActionEvent;

public class CopyPasteAction extends AbstactRoomAction {

    public CopyPasteAction() {
        putValue(SMALL_ICON, loadIcon("/images/duplicate.png"));
        putValue(NAME, "Copy paste");
        putValue(SHORT_DESCRIPTION, "Copy Paste");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        selectedComponent.startCopyPasteState();
    }
}
