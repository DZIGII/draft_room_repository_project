package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import java.util.ArrayList;

public class Building extends DraftNodeComposite {
    public Building(String name) {
        super(name);
    }

    public Building(String name, ArrayList<DraftNode> children) {
        super(name, children);
    }

    public Building(String name, DraftNode parent, ArrayList<DraftNode> children) {
        super(name, parent, children);
    }
}
