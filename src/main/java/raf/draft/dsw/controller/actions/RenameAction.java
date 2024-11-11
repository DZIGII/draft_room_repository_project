package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.EditProjectFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RenameNodeFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class RenameAction extends AbstactRoomAction{
    private RenameNodeFrame frame;

    public RenameAction(){
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/rename.png"));
        putValue(NAME, "Rename");
        putValue(SHORT_DESCRIPTION, "Rename");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if((DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode() != null)
        {
            frame = new RenameNodeFrame();
        }
        else{
            MainFrame.getInstance().getMessageGenerator().generateMessage("Please select node that you want to rename!", "WARNING");
        }
    }

    public RenameNodeFrame getFrame() {
        return frame;
    }

    public void setFrame(RenameNodeFrame frame) {
        this.frame = frame;
    }
}
