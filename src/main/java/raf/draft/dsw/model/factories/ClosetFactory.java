package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.roomElements.Boiler;
import raf.draft.dsw.model.structures.roomElements.Closet;

public class ClosetFactory implements DraftNodeFactory{
    public static int brojac = 0;

    @Override
    public DraftNode createNode(DraftNode parent) {
        return new Closet("Closet " + brojac, parent);
    }
}
