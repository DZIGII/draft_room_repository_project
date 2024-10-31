package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import java.util.ArrayList;

public class ProjectExplorer extends DraftNodeComposite {
    public ProjectExplorer(String name) {
        super(name);
    }

    public ProjectExplorer(String name, ArrayList<DraftNode> children) {
        super(name, children);
    }

    public ProjectExplorer(String name, DraftNode parent, ArrayList<DraftNode> children) {
        super(name, parent, children);
    }
}
