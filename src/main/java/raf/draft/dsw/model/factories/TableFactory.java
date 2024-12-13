package raf.draft.dsw.model.factories;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.roomElements.Closet;
import raf.draft.dsw.model.structures.roomElements.Table;

public class TableFactory implements DraftNodeFactory{
    public static int brojac = 0;

    @Override
    public DraftNode createNode(DraftNode parent) {
        return new Table("Table " + brojac, parent);
    }
}
