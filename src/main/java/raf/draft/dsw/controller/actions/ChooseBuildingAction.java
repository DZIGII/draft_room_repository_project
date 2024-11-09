package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.factories.BuildingFactory;
import raf.draft.dsw.model.factories.RoomFactory;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;

import javax.swing.*;
import java.awt.event.ActionEvent;

public class ChooseBuildingAction extends AbstractAction {
    public ChooseBuildingAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new BuildingFactory());

        MainFrame.getInstance().getDraftTree().getRepository().getFrameChooseDraftNode().dispose();
    }
}
