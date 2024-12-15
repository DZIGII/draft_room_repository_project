package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.roomElements.Bathtub;

public class BathtabFactory implements DraftNodeFactory{
    public static int brojac = 1;

    @Override
    public DraftNode createNode(DraftNode parent) {
        return new Bathtub("bathtub " + brojac++, parent);
    }
}
