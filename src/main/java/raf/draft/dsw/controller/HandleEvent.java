package raf.draft.dsw.controller;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.controller.state.StateManager;
import raf.draft.dsw.controller.state.concrete.AddElementState;
import raf.draft.dsw.gui.swing.ElementDimensionFrame;
import raf.draft.dsw.gui.swing.RoomView;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class HandleEvent implements MouseListener {

    private StateManager stateManager;
    private RoomView roomView;

    public HandleEvent(StateManager stateManager, RoomView roomView) {
        this.stateManager = stateManager;
        this.roomView = roomView;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        stateManager.getCurrentState().log();
        if (stateManager.getCurrentState() instanceof AddElementState) {
            AddElementState addElementState = (AddElementState) stateManager.getCurrentState();
            addElementState.printBed(e.getPoint(), "Bed");
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
