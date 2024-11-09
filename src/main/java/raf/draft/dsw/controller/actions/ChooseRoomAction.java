package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.factories.RoomFactory;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;

import java.awt.event.ActionEvent;

public class ChooseRoomAction extends AbstactRoomAction {
    public ChooseRoomAction() {
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new RoomFactory());

        MainFrame.getInstance().getDraftTree().getRepository().getFrameChooseDraftNode().dispose();

    }
}
