package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import java.util.ArrayList;

public class PojectExplorer extends DraftNodeComposite {
    public PojectExplorer(String name) {
        super(name);
    }

    public PojectExplorer(String name, ArrayList<DraftNode> children) {
        super(name, children);
    }

    public PojectExplorer(String name, DraftNode parent, ArrayList<DraftNode> children) {
        super(name, parent, children);
    }
}
