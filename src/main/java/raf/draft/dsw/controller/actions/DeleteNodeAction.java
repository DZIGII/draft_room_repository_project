package raf.draft.dsw.controller.actions;

import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RenameNodeFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.messages.MessageType;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.net.URL;
import java.util.ArrayList;

public class DeleteNodeAction extends AbstactRoomAction{
    ArrayList<DraftNode> subscribers = new ArrayList<>();

    public DeleteNodeAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_DELETE, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/delete.png"));
        putValue(NAME, "Delete node");
        putValue(SHORT_DESCRIPTION, "Delete node");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getDraftTree().getSelectedNode() != null)
        {
            DraftTreeItem selected = MainFrame.getInstance().getDraftTree().getSelectedNode();

            if(selected.getDraftNode() instanceof ProjectExplorer){
                Message message=new Message("ProjectExplorer cant be deleted!", "ERROR");
                JOptionPane.showMessageDialog(null,message,"ERROR", JOptionPane.ERROR_MESSAGE);
            }else if (selected != null && selected.getParent() != null) {
                notifyRoomDeletionRecursively(selected.getDraftNode());
                if (selected.getDraftNode() instanceof DraftNodeComposite) {
                    removeAllChildren(((DraftNodeComposite) selected.getDraftNode()));
                }

                DraftNode parent = selected.getDraftNode().getParent();
                boolean removed = ((DraftNodeComposite)parent).getChildren().remove(selected.getDraftNode());
                if (removed) {
                    System.out.println("Removed node " + selected.getDraftNode() + " from parent " + parent);
                } else {
                    System.out.println("Node " + selected.getDraftNode() + " not found in parent's children list.");
                }

                if(selected.getDraftNode() instanceof Project){
                    MainFrame.getInstance().nodeDeleted();
                }

                MainFrame.getInstance().getDraftTree().getTreeModel().removeNodeFromParent(selected);
                System.out.println("Deleted successfully node "+ selected);
            }
        }
        else{
            Message message=new Message("Please select node that you want to delete!", "WARNING");
            JOptionPane.showMessageDialog(null,message,"WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }

    //rekurzivno pozivanje
    public void removeAllChildren(DraftNodeComposite node) {
        for (DraftNode child : node.getChildren()) {
            if (child instanceof DraftNodeComposite) {
                removeAllChildren((DraftNodeComposite) child);
            }
        }
        node.getChildren().clear();
    }

    //rekurzivno pozivanje
    public void notifyRoomDeletionRecursively(DraftNode node) {
        if (node instanceof Room) {
            ((Room) node).notifyDeleted();
        }
        else if (node instanceof DraftNodeComposite) {
            for (DraftNode childNode : ((DraftNodeComposite) node).getChildren()) {
                notifyRoomDeletionRecursively(childNode);
            }
        }
    }
}
