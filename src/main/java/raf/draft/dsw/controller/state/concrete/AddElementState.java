package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class AddElementState extends AbstactRoomAction implements State {

    public AddElementState() {
        putValue(SMALL_ICON, loadIcon("/images/add-state.png"));
        putValue(NAME, "Add Element");
        putValue(SHORT_DESCRIPTION, "Add Element");
    }

    @Override
    public void log() {
        System.out.println("Add state");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setAddElementState();
    }
}
