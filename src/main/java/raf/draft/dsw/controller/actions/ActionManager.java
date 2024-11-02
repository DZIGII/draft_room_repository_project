package raf.draft.dsw.controller.actions;

public class ActionManager {

    private ExitAction exitAction;
    private NewProjectAction newProjectAction;
    private ChooseBuildingAction chooseBuildingAction;
    private ChooseRoomAction chooseRoomAction;

    public ActionManager() {
        initialiseActions();
    }

    private void initialiseActions() {
        exitAction = new ExitAction();
        newProjectAction = new NewProjectAction();
        chooseBuildingAction = new ChooseBuildingAction();
        chooseRoomAction = new ChooseRoomAction();
    }

    public ExitAction getExitAction() {
        return exitAction;
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
}
