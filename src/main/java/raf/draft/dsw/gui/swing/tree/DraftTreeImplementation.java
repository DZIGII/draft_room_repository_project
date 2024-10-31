package raf.draft.dsw.gui.swing.tree;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class DraftTreeImplementation implements DraftTree {
    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;

    private static int brojac = 0;

    @Override
    public DraftTreeView generateTree(ProjectExplorer projectExplorer) {
        DraftTreeItem root = new DraftTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new DraftTreeView(treeModel);
        return treeView;
    }

    private DraftNode createChild(DraftNode parent) {
        if (parent instanceof ProjectExplorer) {
            brojac++;
            return new Project("Project " + brojac, parent);
        }
        return null;
    }

    @Override
    public void addChild(DraftTreeItem parent) {
        if (!(parent.getDraftNode() instanceof DraftNodeComposite)) {
            return;
        }
        DraftNode child = createChild(parent.getDraftNode());
        parent.add(new DraftTreeItem(child));
        ((DraftNodeComposite) parent.getDraftNode()).addChild(child);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }


}
