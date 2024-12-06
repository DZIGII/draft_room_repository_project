package raf.draft.dsw.controller.state.concrete;

import com.sun.tools.javac.Main;
import raf.draft.dsw.controller.actions.AbstactRoomAction;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;

import java.awt.event.ActionEvent;

public class CopyPasteState extends AbstactRoomAction implements State {

    public CopyPasteState() {
        putValue(SMALL_ICON, loadIcon("/images/duplicate.png"));
        putValue(NAME, "Add Element");
        putValue(SHORT_DESCRIPTION, "Add Element");
    }

    @Override
    public void log() {
        System.out.println("Copy Paste State");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getStateManager().setCopyPasteState();
    }
}
