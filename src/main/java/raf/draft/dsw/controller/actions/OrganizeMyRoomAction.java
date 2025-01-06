package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.OrganizeMyRoomFrame;
import raf.draft.dsw.gui.swing.RoomDimensionsFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class OrganizeMyRoomAction extends AbstactRoomAction{
    private OrganizeMyRoomFrame frame;
    private RoomDimensionsFrame roomDimensionsFrame;

    public OrganizeMyRoomAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_M, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/organizeMyRoom.png"));
        putValue(NAME, "Organize my room");
        putValue(SHORT_DESCRIPTION, "Organize my room");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(MainFrame.getInstance().getDraftTree().getSelectedNode()!=null)
        {
            DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
            if(selected.getDraftNode() instanceof Project || selected.getDraftNode() instanceof Building)
            {
                frame = new OrganizeMyRoomFrame();
                frame.setVisible(true);
            }
            else{
                MainFrame.getInstance().getMessageGenerator().generateMessage("Please select project or building where room will be created!", "WARNING");
            }
        }
        else
        {
            MainFrame.getInstance().getMessageGenerator().generateMessage("Please select project or building where room will be created!", "WARNING");
        }
    }
}
