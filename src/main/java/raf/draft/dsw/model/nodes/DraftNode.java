package raf.draft.dsw.model.nodes;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;

import javax.swing.*;
import java.util.ArrayList;

public abstract class DraftNode {
    private String name;
    private DraftNode parent = null;

    public DraftNode(String name) {
        this.name = name;
    }

    public DraftNode(String name, DraftNode parent) {
        this.name = name;
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String newName) {
        DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();
        if(!nameAlreadyExists(newName,MainFrame.getInstance().getDraftTree().getTreeView(),selected))
        {
            name = newName;

            MainFrame.getInstance().getActionManager().getRenameAction().getFrame().getNewNodeNameTF().setText("");

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());
            Message message=new Message("You have successfully renamed project!", "INFORMATION");
            JOptionPane.showMessageDialog(null,message,"INFORMATION", JOptionPane.INFORMATION_MESSAGE);
        }
        else{
            Message message=new Message("Name already exists!", "ERROR");
            JOptionPane.showMessageDialog(null,message,"ERROR", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static boolean nameAlreadyExists(String name, JTree tree, DraftNode selectedNode) {
        if (selectedNode == null) {
            return false;
        }
        ArrayList<DraftNode> children = ((DraftNodeComposite)(selectedNode.getParent())).getChildren();
        for (DraftNode child : children) {
            if (name.equals(child.getName())) {
                return true;
            }
        }

        return false;
    }

    public DraftNode getParent() {
        return parent;
    }

    public void setParent(DraftNode parent) {
        this.parent = parent;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof DraftNode && obj != null) {
            return this.getName().equals(((DraftNode)obj).getName());
        }
        return false;
    }

}
