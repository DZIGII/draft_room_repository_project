package raf.draft.dsw.model.nodes;

public class Leaf extends DraftNode{
    public Leaf(String name) {
        super(name);
    }

    public Leaf(String name, DraftNode parent) {
        super(name, parent);
    }
}
