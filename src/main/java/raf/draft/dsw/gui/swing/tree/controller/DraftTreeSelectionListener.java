package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;

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
        if(treeItemSelected.getDraftNode() instanceof Project)
        {
            Project project = (Project) treeItemSelected.getDraftNode();
            project.select();
            System.out.println(treeItemSelected.getDraftNode());
        }
        else if (treeItemSelected.getDraftNode() instanceof Building) {
            Project project = (Project) treeItemSelected.getDraftNode().getParent();
            project.select();
        }
        else if (treeItemSelected.getDraftNode() instanceof Room) {
            if(treeItemSelected.getDraftNode().getParent() instanceof Project)
            {
                Project project = (Project) treeItemSelected.getDraftNode().getParent();
                project.select();
            }
            else if(treeItemSelected.getDraftNode().getParent() instanceof Building)
            {
                Project project = (Project) treeItemSelected.getDraftNode().getParent().getParent();
                project.select();
            }

        }
    }
}
