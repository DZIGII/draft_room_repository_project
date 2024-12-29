package raf.draft.dsw.controller.actions;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class TemplateMenuAction extends AbstactRoomAction{
    public TemplateMenuAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.ALT_MASK));
        putValue(SMALL_ICON, loadIcon("/images/template.png"));
        putValue(NAME, "Template menu");
        putValue(SHORT_DESCRIPTION, "Template menu");
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
