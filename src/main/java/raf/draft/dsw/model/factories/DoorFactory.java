package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.roomElements.Boiler;
import raf.draft.dsw.model.structures.roomElements.Door;

public class DoorFactory implements DraftNodeFactory{
    public static int brojac = 0;

    @Override
    public DraftNode createNode(DraftNode parent) {
        return new Door("Door " + brojac, parent);
    }
}
