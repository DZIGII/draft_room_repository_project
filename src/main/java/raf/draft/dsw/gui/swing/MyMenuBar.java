package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.AboutUsAction;
import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.NewProjectAction;

import javax.swing.*;
import java.awt.event.KeyEvent;

public class MyMenuBar extends JMenuBar {
    public MyMenuBar(){
        JMenu fileMenu = new JMenu("File");
        fileMenu.setMnemonic(KeyEvent.VK_F);

        fileMenu.add(MainFrame.getInstance().getActionManager().getExitAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getNewProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRenameAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getDeleteNodeAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getEditProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getAboutUsAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getUndoAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getRedoAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getSaveAsAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getOpenProjectAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getOrganizeMyRoomAction());
        fileMenu.add(MainFrame.getInstance().getActionManager().getTemplateMenuAction());
        add(fileMenu);
    }
}
