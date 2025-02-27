package raf.draft.dsw.model.nodes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Objects;

public abstract class DraftNode {
    private String name;
    @JsonIgnore
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

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());
            MainFrame.getInstance().getMessageGenerator().generateMessage("You have successfully renamed project!", "INFORMATION");
        }
        else{
            MainFrame.getInstance().getMessageGenerator().generateMessage("Name already exists!", "ERROR");
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
        if(obj instanceof DraftNode) {
            return this.getName().equals(((DraftNode)obj).getName());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
