package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ExitAction;
import raf.draft.dsw.controller.actions.ActionManager;

import javax.swing.*;

public class MyToolBar extends JToolBar {
    public MyToolBar(ActionManager am){
        super(HORIZONTAL);
        setFloatable(false);

        add(new ExitAction());
    }
}
