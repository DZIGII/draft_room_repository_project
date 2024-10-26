package raf.draft.dsw.model;

import raf.draft.dsw.controller.actions.AboutUsAction;
import raf.draft.dsw.controller.actions.ExitAction;

public class ActionManager {

    private ExitAction exitAction;
    private AboutUsAction aboutUsAction;

    public ActionManager() {
    }

    public ExitAction getExitAction() {
        return exitAction;
    }

    public void setExitAction(ExitAction exitAction) {
        this.exitAction = exitAction;
    }

    public AboutUsAction getAboutUsAction() {
        return aboutUsAction;
    }

    public void setAboutUsAction(AboutUsAction aboutUsAction) {
        this.aboutUsAction = aboutUsAction;
    }
}
