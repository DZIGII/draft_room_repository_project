package raf.draft.dsw.controller.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class SaveAsAction extends AbstactRoomAction{
    public SaveAsAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_S, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/saveAs.png"));
        putValue(NAME, "SaveAs");
        putValue(SHORT_DESCRIPTION, "SaveAs");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
