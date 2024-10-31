package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.Leaf;

public class Room extends Leaf {
    public Room(String name, DraftNode parent) {
        super(name, parent);
    }

    public Room(String name) {
        super(name);
    }
}
