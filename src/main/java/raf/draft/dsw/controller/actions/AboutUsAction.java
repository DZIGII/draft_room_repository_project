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

    public Icon loadIcon(String path) {
        Icon icon = null;
        URL ImageURL = getClass().getResource(path);
        if(ImageURL != null)
        {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(100, 100, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else
        {
            System.err.println("File not found");
        }
        return icon;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        new AboutUsFrame();
    }
}
