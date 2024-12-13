package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.roomElements.Closet;
import raf.draft.dsw.model.structures.roomElements.WashingMachine;

public class WashingMachineFactory implements DraftNodeFactory{
    public static int brojac = 0;

    @Override
    public DraftNode createNode(DraftNode parent) {
        return new WashingMachine("Washing Machine " + brojac, parent);
    }
}
