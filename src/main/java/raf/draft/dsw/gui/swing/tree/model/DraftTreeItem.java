package raf.draft.dsw.gui.swing.tree.model;

import raf.draft.dsw.model.nodes.DraftNode;

import javax.swing.tree.DefaultMutableTreeNode;

public class DraftTreeItem extends DefaultMutableTreeNode {
    private DraftNode draftNode;

    public DraftTreeItem(DraftNode draftNode) {
        this.draftNode = draftNode;
    }

    @Override
    public String toString() {
        return draftNode.getName();
    }

    public void setName(String name){
        this.draftNode.setName(name);
    }

    public DraftNode getDraftNode() {
        return draftNode;
    }

    public void setDraftNode(DraftNode draftNode) {
        this.draftNode = draftNode;
    }
}
