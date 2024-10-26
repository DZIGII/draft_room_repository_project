package raf.draft.dsw.model.nodes;

import java.util.ArrayList;

public abstract class DraftNodeComposite extends DraftNode {
    private ArrayList<DraftNode> children = new ArrayList<DraftNode>();

    public DraftNodeComposite(String name) {
        super(name);
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

    private void addChild(DraftNode dn){
        children.add(dn);
        dn.setParent(this);
    }

    private void removeChild(DraftNode dn){
        children.remove(dn);
    }

    public ArrayList<DraftNode> getChildren() {
        return children;
    }

    public void setChildren(ArrayList<DraftNode> children) {
        this.children = children;
    }
}
