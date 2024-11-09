package raf.draft.dsw.model;

import raf.draft.dsw.model.repository.DraftRoomRepository;
import raf.draft.dsw.model.structures.ProjectExplorer;

public class DraftRoomExplorerImplementation implements DraftRoomRepository {
    private ProjectExplorer root;

    public DraftRoomExplorerImplementation() {
        this.root = new ProjectExplorer("My Project Explorer");
    }

    @Override
    public ProjectExplorer getRoot() {
        return root;
    }
}
