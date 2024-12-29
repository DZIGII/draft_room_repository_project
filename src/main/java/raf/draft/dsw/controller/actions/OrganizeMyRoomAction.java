package raf.draft.dsw.controller.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OrganizeMyRoomAction extends AbstactRoomAction{
    public OrganizeMyRoomAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/organizeMyRoom.png"));
        putValue(NAME, "Organize my room");
        putValue(SHORT_DESCRIPTION, "Organize my room");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
