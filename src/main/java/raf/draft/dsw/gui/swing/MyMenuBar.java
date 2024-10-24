package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.AboutUsAction;
import raf.draft.dsw.controller.ExitAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        JMenu aboutUsMenu = new JMenu("About Us");
        fileMenu.setMnemonic(KeyEvent.VK_F);
        ExitAction ea = new ExitAction();
        AboutUsAction aboutUsAction = new AboutUsAction();
        fileMenu.add(ea);
        aboutUsMenu.add(aboutUsAction);
        add(fileMenu);
        add(aboutUsMenu);
    }
}
