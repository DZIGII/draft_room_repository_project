package raf.draft.dsw.model.nodes;

import java.util.ArrayList;

public abstract class DraftNodeComposite extends DraftNode {
    private ArrayList<DraftNode> children = new ArrayList<DraftNode>();

    public DraftNodeComposite(String name) {
        super(name);
    }

    public DraftNodeComposite(String name, DraftNode parent) {
        super(name, parent);
    }

    public DraftNodeComposite(String name, ArrayList<DraftNode> children) {
        super(name);
        setParent(null);
        this.children = children;
    }

    public DraftNodeComposite(String name, DraftNode parent, ArrayList<DraftNode> children) {
        super(name, parent);
        this.children = children;
    }

    public void addChild(DraftNode dn){
        children.add(dn);
        dn.setParent(this);
    }

    public void removeChild(DraftNode dn){
        children.remove(dn);
    }

    public DraftNode getChildByName(String name) {
        for (DraftNode child: this.getChildren()) {
            if (name.equals(child.getName())) {
                return child;
            }
        }
        return null;
    }

    public ArrayList<DraftNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<DraftNode> children) {
        this.children = children;
    }
}
