package raf.draft.dsw.model.repository;

import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.ProjectExplorer;

public class DraftRoomExplorerImplementation implements DraftRoomRepository{
    private ProjectExplorer root;

    public DraftRoomExplorerImplementation() {
        this.root = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getRoot() {
        return root;
    }
}
