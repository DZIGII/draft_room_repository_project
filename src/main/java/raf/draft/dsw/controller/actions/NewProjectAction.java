package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.AboutUsFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.net.URL;

public class NewProjectAction extends AbstactRoomAction{
    public NewProjectAction() {
        putValue(ACCELERATOR_KEY, KeyStroke.getKeyStroke(KeyEvent.VK_N, ActionEvent.CTRL_MASK));
        putValue(SMALL_ICON, loadIcon("/images/plus.png"));
        putValue(NAME, "New Project");
        putValue(SHORT_DESCRIPTION, "New Project");
    }

    public void actionPerformed(ActionEvent arg0) {
        if((DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode()!=null)
        {
            DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();
            if(selected.getDraftNode() instanceof Room)
            {
                Message message=new Message("Room does not have childrens", "ERROR");
                JOptionPane.showMessageDialog(null,message,"ERROR", JOptionPane.ERROR_MESSAGE);
            }
            else{
                MainFrame.getInstance().getDraftTree().addChild(selected);
            }
        }
        else{
            Message message=new Message("Please select project explorer to add his first child!", "WARNING");
            JOptionPane.showMessageDialog(null,message,"WARNING", JOptionPane.WARNING_MESSAGE);
        }

    }
}
