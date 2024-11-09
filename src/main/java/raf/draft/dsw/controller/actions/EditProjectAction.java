package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.EditProjectFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;

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
        if((DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode() != null)
        {
            DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();
            if(selected instanceof Project) {
                System.out.println(selected);
                frame = new EditProjectFrame();
            }
            else {
                Message message=new Message("You can edit only project", "ERROR");
                JOptionPane.showMessageDialog(null,message,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
        }
        else{
            Message message=new Message("Please select node that you want to edit!", "WARNING");
            JOptionPane.showMessageDialog(null,message,"WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    public EditProjectFrame getFrame() {
        return frame;
    }

    public void setFrame(EditProjectFrame frame) {
        this.frame = frame;
    }
}
