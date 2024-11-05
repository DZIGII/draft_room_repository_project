package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class EditProjectExitAction extends AbstactRoomAction{
    public EditProjectExitAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().dispose();
    }
}
