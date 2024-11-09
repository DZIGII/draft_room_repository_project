package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class RenameSaveAction extends AbstactRoomAction{
    @Override
    public void actionPerformed(ActionEvent e) {
        DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();

        selected.setName(MainFrame.getInstance().getActionManager().getRenameAction().getFrame().getNewNodeNameTF().getText());

        MainFrame.getInstance().getActionManager().getRenameAction().getFrame().getNewNodeNameTF().setText("");

        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());
    }
}
