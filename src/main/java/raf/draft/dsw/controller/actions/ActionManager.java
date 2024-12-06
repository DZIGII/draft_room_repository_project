package raf.draft.dsw.controller.actions;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private AboutUsAction aboutUsAction;
    private ChooseBuildingAction chooseBuildingAction;
    private ChooseRoomAction chooseRoomAction;
    private DeleteNodeAction deleteNodeAction;
    private RenameAction renameAction;
    private RenameSaveAction renameSaveAction;
    private EditProjectAction editProjectAction;
    private EditProjectExitAction editProjectExitAction;
    private EditProjectSaveAction editProjectSaveAction;
    private RenameExitAction renameExitAction;

    private AddElementAction addElementAction;
    private  CopyPasteAction copyPasteAction;
    private  DeleteElementAction deleteElementAction;
    private EditAction editAction;
    private EditRoomAction editRoomAction;
    private MoveAction moveAction;
    private ResizeAction resizeAction;
    private RotateAction rotateAction;
    private SelectAction selectAction;
    private ZoomAction zoomAction;


    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        chooseBuildingAction = new ChooseBuildingAction();
        chooseRoomAction = new ChooseRoomAction();
        deleteNodeAction = new DeleteNodeAction();
        renameAction = new RenameAction();
        renameSaveAction = new RenameSaveAction();
        renameExitAction = new RenameExitAction();
        aboutUsAction = new AboutUsAction();
        editProjectAction = new EditProjectAction();
        editProjectExitAction = new EditProjectExitAction();
        editProjectSaveAction = new EditProjectSaveAction();

        addElementAction = new AddElementAction();
        copyPasteAction = new CopyPasteAction();
        deleteElementAction = new DeleteElementAction();
        editAction = new EditAction();
        editRoomAction = new EditRoomAction();
        moveAction = new MoveAction();
        resizeAction = new ResizeAction();
        rotateAction = new RotateAction();
        selectAction = new SelectAction();
        zoomAction = new ZoomAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public EditProjectAction getEditProjectAction() {
        return editProjectAction;
    }

    public void setEditProjectAction(EditProjectAction editProjectAction) {
        this.editProjectAction = editProjectAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public NewProjectAction getNewProjectAction() {
        return newProjectAction;
    }

    public void setNewProjectAction(NewProjectAction newProjectAction) {
        this.newProjectAction = newProjectAction;
    }

    public ChooseBuildingAction getChooseBuildingAction() {
        return chooseBuildingAction;
    }

    public void setChooseBuildingAction(ChooseBuildingAction chooseBuildingAction) {
        this.chooseBuildingAction = chooseBuildingAction;
    }

    public ChooseRoomAction getChooseRoomAction() {
        return chooseRoomAction;
    }

    public void setChooseRoomAction(ChooseRoomAction chooseRoomAction) {
        this.chooseRoomAction = chooseRoomAction;
    }

    public DeleteNodeAction getDeleteNodeAction() {
        return deleteNodeAction;
    }

    public void setDeleteNodeAction(DeleteNodeAction deleteNodeAction) {
        this.deleteNodeAction = deleteNodeAction;
    }

    public RenameAction getRenameAction() {
        return renameAction;
    }

    public void setRenameAction(RenameAction renameAction) {
        this.renameAction = renameAction;
    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public void setAboutUsAction(AboutUsAction aboutUsAction) {
        this.aboutUsAction = aboutUsAction;
    }

    public EditProjectSaveAction getEditProjectSaveAction() {
        return editProjectSaveAction;
    }

    public void setEditProjectSaveAction(EditProjectSaveAction editProjectSaveAction) {
        this.editProjectSaveAction = editProjectSaveAction;
    }

    public RenameSaveAction getRenameSaveAction() {
        return renameSaveAction;
    }

    public void setRenameSaveAction(RenameSaveAction renameSaveAction) {
        this.renameSaveAction = renameSaveAction;
    }

    public EditProjectExitAction getEditProjectExitAction() {
        return editProjectExitAction;
    }

    public void setEditProjectExitAction(EditProjectExitAction editProjectExitAction) {
        this.editProjectExitAction = editProjectExitAction;
    }

    public RenameExitAction getRenameExitAction() {
        return renameExitAction;
    }

    public void setRenameExitAction(RenameExitAction renameExitAction) {
        this.renameExitAction = renameExitAction;
    }

    public AddElementAction getAddElementAction() {
        return addElementAction;
    }

    public void setAddElementAction(AddElementAction addElementAction) {
        this.addElementAction = addElementAction;
    }

    public CopyPasteAction getCopyPasteAction() {
        return copyPasteAction;
    }

    public void setCopyPasteAction(CopyPasteAction copyPasteAction) {
        this.copyPasteAction = copyPasteAction;
    }

    public DeleteElementAction getDeleteElementAction() {
        return deleteElementAction;
    }

    public void setDeleteElementAction(DeleteElementAction deleteElementAction) {
        this.deleteElementAction = deleteElementAction;
    }

    public EditAction getEditAction() {
        return editAction;
    }

    public void setEditAction(EditAction editAction) {
        this.editAction = editAction;
    }

    public EditRoomAction getEditRoomAction() {
        return editRoomAction;
    }

    public void setEditRoomAction(EditRoomAction editRoomAction) {
        this.editRoomAction = editRoomAction;
    }

    public MoveAction getMoveAction() {
        return moveAction;
    }

    public void setMoveAction(MoveAction moveAction) {
        this.moveAction = moveAction;
    }

    public ResizeAction getResizeAction() {
        return resizeAction;
    }

    public void setResizeAction(ResizeAction resizeAction) {
        this.resizeAction = resizeAction;
    }

    public RotateAction getRotateAction() {
        return rotateAction;
    }

    public void setRotateAction(RotateAction rotateAction) {
        this.rotateAction = rotateAction;
    }

    public SelectAction getSelectAction() {
        return selectAction;
    }

    public void setSelectAction(SelectAction selectAction) {
        this.selectAction = selectAction;
    }

    public ZoomAction getZoomAction() {
        return zoomAction;
    }

    public void setZoomAction(ZoomAction zoomAction) {
        this.zoomAction = zoomAction;
    }
}
