package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.AboutUsFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;

public class AboutUsAction extends AbstactRoomAction {

    public AboutUsAction() {
        putValue(NAME, "About Us");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutUsFrame();
    }
}
