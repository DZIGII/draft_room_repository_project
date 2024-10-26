package raf.draft.dsw.model.repository;

import raf.draft.dsw.model.nodes.DraftNodeComposite;

public class DraftRoomExplorerImplementation implements DraftRoomRepository{
    private DraftNodeComposite root;

    public DraftRoomExplorerImplementation(DraftNodeComposite root) {
        this.root = root;
    }

    @Override
    public DraftNodeComposite getRoot() {
        return root;
    }
}
