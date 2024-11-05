package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RenameExitAction extends AbstactRoomAction {
    public RenameExitAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getActionManager().getRenameAction().getFrame().dispose();
    }
}
