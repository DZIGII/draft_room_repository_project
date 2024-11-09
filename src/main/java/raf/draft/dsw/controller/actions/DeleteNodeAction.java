package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RenameNodeFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.structures.ProjectExplorer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class DeleteNodeAction extends AbstactRoomAction{
    public DeleteNodeAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete node");
        putValue(SHORT_DESCRIPTION, "Delete node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode() != null)
        {
            DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
            if(selected.getDraftNode() instanceof ProjectExplorer){
                Message message=new Message("ProjectExplorer cant be deleted!", "ERROR");
                JOptionPane.showMessageDialog(null,message,"ERROR", JOptionPane.ERROR_MESSAGE);
            }else if (selected != null && selected.getParent() != null) {
                MainFrame.getInstance().getDraftTree().getTreeModel().removeNodeFromParent(selected);
                System.out.println("Deleted successfully node "+ selected);
            }
        }
        else{
            Message message=new Message("Please select node that you want to delete!", "WARNING");
            JOptionPane.showMessageDialog(null,message,"WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }
}
