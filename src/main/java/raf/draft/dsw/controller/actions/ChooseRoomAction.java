package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Room;

import java.awt.event.ActionEvent;

public class ChooseRoomAction extends AbstactRoomAction {
    public ChooseRoomAction() {

    }


    @Override
    public void actionPerformed(ActionEvent e) {
        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
        MainFrame.getInstance().getDraftTree().addChosenChild(selected, new Room("Room"));
        
        MainFrame.getInstance().getDraftTree().getFrame().dispose();
        MainFrame.getInstance().getDraftTree().getFrame().setVisible(false);
    }
}
