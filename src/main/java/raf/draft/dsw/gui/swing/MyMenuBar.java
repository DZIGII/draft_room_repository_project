package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.AboutUsAction;
import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.NewProjectAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        JMenu aboutUsMenu = new JMenu("About Us");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        AboutUsAction aboutUsAction = new AboutUsAction();

        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRenameAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        aboutUsMenu.add(MainFrame.getInstance().getActionManager().getAboutUsAction());
        add(fileMenu);
        add(aboutUsMenu);
    }
}
