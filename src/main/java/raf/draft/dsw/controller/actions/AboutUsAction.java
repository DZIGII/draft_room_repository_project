package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.AboutUsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class AboutUsAction extends AbstactRoomAction {

    public AboutUsAction() {
        putValue(NAME, "About Us");
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_A, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/aboutUs.png"));
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutUsFrame();
    }
}
