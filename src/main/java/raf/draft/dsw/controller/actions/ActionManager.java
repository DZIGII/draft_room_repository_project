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
}
