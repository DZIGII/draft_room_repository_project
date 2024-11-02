package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Building;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChooseBuildingAction extends AbstractAction {
    public ChooseBuildingAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
        MainFrame.getInstance().getDraftTree().addChosenChild(selected, new Building("Building"));

        MainFrame.getInstance().getDraftTree().getFrame().dispose();
        MainFrame.getInstance().getDraftTree().getFrame().setVisible(false);
    }
}
