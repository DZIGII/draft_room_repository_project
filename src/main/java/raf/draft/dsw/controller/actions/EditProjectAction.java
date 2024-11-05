package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.EditProjectFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class EditProjectAction extends AbstactRoomAction {
    private EditProjectFrame frame;

    public EditProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/edit-icon.png"));
        putValue(NAME, "Edit Project");
        putValue(SHORT_DESCRIPTION, "Edit Project");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();
        if(selected instanceof Project) {
            System.out.println(selected);
            frame = new EditProjectFrame();
        }
        else {
            //Ovde bi trebao observer sa nekim alertom da se ne moze menjati nesto sto nije tip Project
        }
    }

    public EditProjectFrame getFrame() {
        return frame;
    }

    public void setFrame(EditProjectFrame frame) {
        this.frame = frame;
    }
}
