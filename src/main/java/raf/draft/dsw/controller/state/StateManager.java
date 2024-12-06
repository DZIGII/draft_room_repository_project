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
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setAddElementState() {
        currentState = (State) addElementState;
    }

    public void setCopyPasteState() {
        currentState = (State) copyPasteState;
    }

    public void setDeleteState() {
        currentState = (State) deleteState;
    }

    public void setEditRoomState() {
        currentState = (State) editState;
    }

    public void setEditState() {
        currentState = (State) editState;
    }

    public void setMoveState() {
        currentState = (State) moveState;
    }

    public void setResizeState() {
        currentState = (State) resizeState;
    }

    public void setRoteteState() {
        currentState = (State) roteteState;
    }

    public void setSelectState() {
        currentState = (State) selectState;
    }

    public void setZoomState() {
        currentState = (State) zoomState;
    }

    public AddElementState getAddElementState() {
        return addElementState;
    }

    public CopyPasteState getCopyPasteState() {
        return copyPasteState;
    }

    public DeleteState getDeleteState() {
        return deleteState;
    }

    public EditRoomState getEditRoomState() {
        return editRoomState;
    }

    public EditState getEditState() {
        return editState;
    }

    public MoveState getMoveState() {
        return moveState;
    }

    public ResizeState getResizeState() {
        return resizeState;
    }

    public RotateState getRoteteState() {
        return roteteState;
    }

    public SelectState getSelectState() {
        return selectState;
    }

    public ZoomState getZoomState() {
        return zoomState;
    }
}
