package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.ExitAction;
import raf.draft.dsw.model.ActionManager;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(ActionManager actionManager){
        super(HORIZONTAL);
        setFloatable(false);

        //ExitAction ea = new ExitAction();
        add(actionManager.getExitAction());
    }
}
