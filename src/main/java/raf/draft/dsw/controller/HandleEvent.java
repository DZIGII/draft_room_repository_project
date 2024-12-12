package raf.draft.dsw.controller;

import raf.draft.dsw.controller.state.StateManager;
import raf.draft.dsw.controller.state.concrete.AddBedState;
import raf.draft.dsw.controller.state.concrete.AddDoorState;
import raf.draft.dsw.controller.state.concrete.SelectState;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.ElementPainter;

import java.awt.*;
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
        if (stateManager.getCurrentState() instanceof AddBedState) {
            AddBedState addBedState = (AddBedState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addBedState.paintElement(point, roomView);
        }
        if (stateManager.getCurrentState() instanceof AddDoorState) {
            AddDoorState addDoorState = (AddDoorState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addDoorState.paintElement(point, roomView);
        }
        if (stateManager.getCurrentState() instanceof SelectState) {
            SelectState selectState = (SelectState) stateManager.getCurrentState();

        }
        for (ElementPainter elementPainter : roomView.getPainters()) {
            elementPainter.elementAt(null, e.getPoint());
        }
//        if (stateManager.getCurrentState() instanceof vfdsfa)

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
