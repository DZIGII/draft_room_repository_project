package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;

import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreePath;

public class DraftTreeSelectionListener implements TreeSelectionListener {
    @Override
    public void valueChanged(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        DraftTreeItem treeItemSelected = (DraftTreeItem) path.getLastPathComponent();
        System.out.println("Selected node: "+ treeItemSelected.getDraftNode().getName());
        System.out.println("Path to selected node: "+e.getPath());
    }
}
