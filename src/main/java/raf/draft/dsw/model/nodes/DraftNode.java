package raf.draft.dsw.model.nodes;

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

    public void setName(String name) {
        this.name = name;
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
