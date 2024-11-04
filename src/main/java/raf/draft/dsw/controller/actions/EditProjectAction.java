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

    public EditProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_P, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/edit-icon.png"));
        putValue(NAME, "Edit Project");
        putValue(SHORT_DESCRIPTION, "Edit Project");
    }

    public Icon loadIcon(String fileName) {
        URL imageURL = getClass().getResource(fileName);
        Icon icon = null;

        if (imageURL != null) {
            ImageIcon originalImg = new ImageIcon(imageURL);
            Image scaledImage = originalImg.getImage().getScaledInstance(32, 32, Image.SCALE_SMOOTH);
            icon = new ImageIcon(scaledImage);
        }
        else {
            System.err.println("Resource not found: " + fileName);
        }
        return icon;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();
        if(selected instanceof Project) {
            System.out.println(selected);
            new EditProjectFrame(selected);
        }
        else {
            //Ovde bi trebao observer sa nekim alertom da se ne moze menjati nesto sto nije tip Project
        }
    }

}
