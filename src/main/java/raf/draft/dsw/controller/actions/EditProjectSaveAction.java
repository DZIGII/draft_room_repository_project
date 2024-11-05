package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class EditProjectSaveAction extends AbstactRoomAction{
    public EditProjectSaveAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();

        if(selected instanceof Project)
        {
            ((Project) selected).setProjectName(MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getNewName().getText());
            ((Project) selected).setCreatorName(MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getNewAuthor().getText());
            ((Project) selected).setPathToProjectResources(MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getNewPath().getText());

            MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getNewName().setText("");
            MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getNewAuthor().setText("");
            MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getNewPath().setText("");
            MainFrame.getInstance().getActionManager().getEditProjectAction().getFrame().getSuccses().setText("You have successfully renamed project!");

            SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());
        }
    }
}
