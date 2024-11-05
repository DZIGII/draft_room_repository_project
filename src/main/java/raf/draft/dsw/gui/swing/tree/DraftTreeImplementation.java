package raf.draft.dsw.gui.swing.tree;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.gui.swing.tree.view.DraftTreeView;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
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
    private ChooseDraftNodeFrame frame;
    private DraftNode child;

    public static int brojac = 0;
    public static int brojac2 = 0;
    public static int brojac3 = 0;

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
        else if(parent instanceof Project) {
            frame = new ChooseDraftNodeFrame();
            frame.setVisible(true);
            return null;
        }
        else if(parent instanceof Building) {
            brojac3++;
            return new Room("Room " + brojac3, parent);
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

    public void addChosenChild(DraftTreeItem parent, DraftNode newChild) {
        if (!(parent.getDraftNode() instanceof DraftNodeComposite)) {
            return;
        }
        parent.add(new DraftTreeItem(newChild));
        ((DraftNodeComposite) parent.getDraftNode()).addChild(newChild);
        treeView.expandPath(treeView.getSelectionPath());
        SwingUtilities.updateComponentTreeUI(treeView);
    }

    @Override
    public DraftTreeItem getSelectedNode() {
        return (DraftTreeItem) treeView.getLastSelectedPathComponent();
    }

    public ChooseDraftNodeFrame getFrame() {
        return frame;
    }

    public void setFrame(ChooseDraftNodeFrame frame) {
        this.frame = frame;
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
}
