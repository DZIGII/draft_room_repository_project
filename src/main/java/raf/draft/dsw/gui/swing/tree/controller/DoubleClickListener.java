package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class DoulbleClickListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            DraftNode selectedItem = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();
            if (selectedItem != null) {
                System.out.println("Dvostruki klik na: " + selectedItem);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
