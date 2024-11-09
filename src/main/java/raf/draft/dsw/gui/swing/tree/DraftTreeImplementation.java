package raf.draft.dsw.gui.swing.tree;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.gui.swing.TabFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.factories.DraftNodeFactory;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.repository.DraftRepository;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.util.Random;

public class DraftTreeImplementation implements DraftTree {
    private DraftTreeView treeView;
    private DefaultTreeModel treeModel;
    private DraftNode child;
    private DraftRepository repository = new DraftRepository();

    @Override
    public DraftTreeView generateTree(ProjectExplorer projectExplorer) {
        DraftTreeItem root = new DraftTreeItem(projectExplorer);
        treeModel = new DefaultTreeModel(root);
        treeView = new DraftTreeView(treeModel);
        return treeView;
    }

    private DraftNode createChild(DraftNode parent) {
        DraftNodeFactory factory = repository.getFactory(parent);
        if (factory != null) {
            return factory.createNode(parent);
        }
        return null;
    }

    @Override
    public void addChild(DraftTreeItem parent) {
        if (!(parent.getDraftNode() instanceof DraftNodeComposite)) {
            return;
        }
        child = createChild(parent.getDraftNode());
        if (child != null) {
            parent.add(new DraftTreeItem(child));
            ((DraftNodeComposite) parent.getDraftNode()).addChild(child);
            treeView.expandPath(treeView.getSelectionPath());
            SwingUtilities.updateComponentTreeUI(treeView);

        }
    }
//
//    public void addChosenChild(DraftTreeItem parent, DraftNode newChild) {
//        if (!(parent.getDraftNode() instanceof DraftNodeComposite)) {
//            return;
//        }
//        parent.add(new DraftTreeItem(newChild));
//        ((DraftNodeComposite) parent.getDraftNode()).addChild(newChild);
//        treeView.expandPath(treeView.getSelectionPath());
//        SwingUtilities.updateComponentTreeUI(treeView);
//    }

    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }

    public DraftNode getChild() {
        return child;
    }

    public void setChild(DraftNode child) {
        this.child = child;
    }

    public DraftTreeView getTreeView() {
        return treeView;
    }

    public void setTreeView(DraftTreeView treeView) {
        this.treeView = treeView;
    }

    public DefaultTreeModel getTreeModel() {
        return treeModel;
    }

    public void setTreeModel(DefaultTreeModel treeModel) {
        this.treeModel = treeModel;
    }

    public DraftRepository getRepository() {
        return repository;
    }

    public void setRepository(DraftRepository repository) {
        this.repository = repository;
    }
}
