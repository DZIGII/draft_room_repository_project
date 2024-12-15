package raf.draft.dsw.controller;

import raf.draft.dsw.controller.state.StateManager;
import raf.draft.dsw.controller.state.concrete.AddBedState;
import raf.draft.dsw.controller.state.concrete.AddDoorState;
import raf.draft.dsw.controller.state.concrete.SelectState;
import raf.draft.dsw.controller.state.concrete.*;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.ElementPainter;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class HandleEvent implements MouseListener, MouseMotionListener {

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

        if(stateManager.getCurrentState() instanceof AddBathtubState)
        {
            AddBathtubState addBathtubState = (AddBathtubState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addBathtubState.paintElement(point, roomView);
        }
        if(stateManager.getCurrentState() instanceof AddTableState)
        {
            AddTableState addTableState = (AddTableState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addTableState.paintElement(point, roomView);
        }
        if(stateManager.getCurrentState() instanceof AddClosetState)
        {
            AddClosetState addClosetState = (AddClosetState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addClosetState.paintElement(point, roomView);
        }
        if(stateManager.getCurrentState() instanceof AddWashingMachineState)
        {
            AddWashingMachineState addWashingMachineState = (AddWashingMachineState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addWashingMachineState.paintElement(point, roomView);
        }
        if(stateManager.getCurrentState() instanceof AddBoilerState)
        {
            AddBoilerState addBoilerState = (AddBoilerState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addBoilerState.paintElement(point, roomView);
        }
        if(stateManager.getCurrentState() instanceof AddToiletState)
        {
            AddToiletState addToiletState = (AddToiletState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addToiletState.paintElement(point, roomView);
        }
        if(stateManager.getCurrentState() instanceof AddSinkState)
        {
            AddSinkState addSinkState = (AddSinkState) stateManager.getCurrentState();
            Point point = e.getPoint();
            addSinkState.paintElement(point, roomView);
        }
        if (stateManager.getCurrentState() instanceof SelectState) {
            SelectState selectState = (SelectState) stateManager.getCurrentState();
            selectState.unselect(roomView);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (stateManager.getCurrentState() instanceof SelectState) {
            SelectState selectState = (SelectState) stateManager.getCurrentState();
            selectState.mousePressed(e, roomView);
        }
        if (stateManager.getCurrentState() instanceof MoveState) {
            MoveState moveState = (MoveState) stateManager.getCurrentState();
            moveState.mousePressed(e, roomView);
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (stateManager.getCurrentState() instanceof SelectState) {
            SelectState selectState = (SelectState) stateManager.getCurrentState();
            selectState.mouseRelease(e, roomView);
        }
        if (stateManager.getCurrentState() instanceof MoveState) {
            MoveState moveState = (MoveState) stateManager.getCurrentState();
            moveState.mouseRelease(e, roomView);
        }
    }


    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if (stateManager.getCurrentState() instanceof SelectState) {
            SelectState selectState = (SelectState) stateManager.getCurrentState();
            selectState.mouseDragged(e, roomView);
        }
        if (stateManager.getCurrentState() instanceof MoveState) {
            MoveState moveState = (MoveState) stateManager.getCurrentState();
            moveState.mouseDragged(e, roomView);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
}
