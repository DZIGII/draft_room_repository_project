package raf.draft.dsw.controller.state;

import raf.draft.dsw.controller.state.concrete.*;

public class StateManager {
    // NIKAKO NE ZOVI ....getStateManager().setAddElementState()
    // NEGO roomView.startAddElementState()
    private State currentState;
    private AddElementState addElementState;
    private CopyPasteState copyPasteState;
    private DeleteState deleteState;
    private EditRoomState editRoomState;
    private EditState editState;
    private MoveState moveState;
    private ResizeState resizeState;
    private RotateState roteteState;
    private SelectState selectState;
    private ZoomState zoomState;

    private AddBedState addBedState;
    private AddDoorState addDoorState;
    private AddTableState addTableState;
    private AddClosetState addClosetState;
    private AddBathtubState addBathtubState;
    private AddWashingMachineState addWashingMachineState;
    private AddBoilerState addBoilerState;
    private AddToiletState addToiletState;
    private AddSinkState addSinkState;

    public StateManager() {
        initStates();
    }

    private void initStates() {
        addElementState = new AddElementState();
        copyPasteState = new CopyPasteState();
        deleteState = new DeleteState();
        editRoomState = new EditRoomState();
        editState = new EditState();
        moveState = new MoveState();
        resizeState = new ResizeState();
        roteteState = new RotateState();
        selectState = new SelectState();
        zoomState = new ZoomState();
        addBedState = new AddBedState();
        addDoorState = new AddDoorState();
        addTableState = new AddTableState();
        addClosetState = new AddClosetState();
        addBathtubState = new AddBathtubState();
        addWashingMachineState = new AddWashingMachineState();
        addBoilerState = new AddBoilerState();
        addToiletState = new AddToiletState();
        addSinkState = new AddSinkState();
        currentState = selectState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setAddElementState() {
        currentState =  addElementState;
    }

    public void setCopyPasteState() {
        currentState = copyPasteState;
    }

    public void setDeleteState() {
        currentState = deleteState;
    }

    public void setEditRoomState() {
        currentState = editRoomState;
    }

    public void setEditState() {
        currentState = editState;
    }

    public void setMoveState() {
        currentState =  moveState;
    }

    public void setResizeState() {
        currentState = resizeState;
    }

    public void setRoteteState() {
        currentState = roteteState;
    }

    public void setSelectState() {
        currentState =  selectState;
    }

    public void setZoomState() {
        currentState = zoomState;
    }

    public void setAddBedState() {
        currentState = addBedState;
    }

    public void setAddDoorState() {
        currentState = addDoorState;
    }

    public void setAddTableState() {
        currentState = addTableState;
    }

    public void setAddClosetState() {
        currentState = addClosetState;
    }

    public void setAddBathtubState() {
        currentState = addBathtubState;
    }

    public void setAddWashingMachineState() {
        currentState = addWashingMachineState;
    }

    public void setAddBoilerState() {
        currentState = addBoilerState;
    }

    public void setAddToiletState(){
        currentState = addToiletState;
    }

    public void setAddSinkState() {
        currentState = addSinkState;
    }

}
