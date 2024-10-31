package raf.draft.dsw.gui.swing.tree;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.structures.ProjectExplorer;

public interface DraftTree {
    DraftTreeView generateTree(ProjectExplorer projectExplorer);
    void addChild(DraftTreeItem parent);
    DraftTreeItem getSelectedNode();
}
