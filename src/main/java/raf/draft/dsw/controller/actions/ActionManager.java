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
    private OpenProjectAction openProjectAction;
    private OrganizeMyRoomAction organizeMyRoomAction;
    private RedoAction redoAction;
    private UndoAction undoAction;
    private SaveAction saveAction;
    private SaveAsAction saveAsAction;
    private TemplateMenuAction templateMenuAction;

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
        openProjectAction = new OpenProjectAction();
        organizeMyRoomAction = new OrganizeMyRoomAction();
        redoAction = new RedoAction();
        undoAction = new UndoAction();
        saveAction = new SaveAction();
        saveAsAction = new SaveAsAction();
        templateMenuAction = new TemplateMenuAction();

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

    public OpenProjectAction getOpenProjectAction() {
        return openProjectAction;
    }

    public void setOpenProjectAction(OpenProjectAction openProjectAction) {
        this.openProjectAction = openProjectAction;
    }

    public OrganizeMyRoomAction getOrganizeMyRoomAction() {
        return organizeMyRoomAction;
    }

    public void setOrganizeMyRoomAction(OrganizeMyRoomAction organizeMyRoomAction) {
        this.organizeMyRoomAction = organizeMyRoomAction;
    }

    public RedoAction getRedoAction() {
        return redoAction;
    }

    public void setRedoAction(RedoAction redoAction) {
        this.redoAction = redoAction;
    }

    public UndoAction getUndoAction() {
        return undoAction;
    }

    public void setUndoAction(UndoAction undoAction) {
        this.undoAction = undoAction;
    }

    public SaveAction getSaveAction() {
        return saveAction;
    }

    public void setSaveAction(SaveAction saveAction) {
        this.saveAction = saveAction;
    }

    public SaveAsAction getSaveAsAction() {
        return saveAsAction;
    }

    public void setSaveAsAction(SaveAsAction saveAsAction) {
        this.saveAsAction = saveAsAction;
    }

    public TemplateMenuAction getTemplateMenuAction() {
        return templateMenuAction;
    }

    public void setTemplateMenuAction(TemplateMenuAction templateMenuAction) {
        this.templateMenuAction = templateMenuAction;
    }
}
