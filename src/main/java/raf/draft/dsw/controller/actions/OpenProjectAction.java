package raf.draft.dsw.controller.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OpenProjectAction extends AbstactRoomAction{
    public OpenProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_O, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/openProject.png"));
        putValue(NAME, "Open project");
        putValue(SHORT_DESCRIPTION, "Open project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
