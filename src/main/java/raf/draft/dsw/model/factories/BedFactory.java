package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Bed;

public class BedFactory implements DraftNodeFactory{
    public static int brojac = 0;

    @Override
    public DraftNode createNode(DraftNode parent) {
        return new Bed("Bed " + brojac, parent);
    }
}
