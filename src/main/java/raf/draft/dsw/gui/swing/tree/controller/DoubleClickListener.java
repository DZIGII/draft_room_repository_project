package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.TabFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.nodes.Leaf;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class DoubleClickListener implements MouseListener {
    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 2) {
            DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();

            if(selected instanceof Project) {
                ArrayList<DraftNode> projectNodes = ((Project) selected).getChildren();
                JTabbedPane tabFrame = new JTabbedPane();
                Icon icon = new TabFrame().loadIcon("/images/room.png");
                Color colorBuilding = new Building("").getColor();

                int cnt = 0;
                for(DraftNode node : projectNodes) {
                    if(node instanceof DraftNodeComposite) {
                        ArrayList<DraftNode> buildingNodes = ((DraftNodeComposite) node).getChildren();
                        for(DraftNode room : buildingNodes) {
                            tabFrame.addTab(room.getName(), icon, new TabFrame());
                            tabFrame.setBackgroundAt(cnt++, colorBuilding);
                        }
                    }
                    if(node instanceof Leaf) { // znaci da je Room
                        tabFrame.addTab(node.getName(), icon, new TabFrame());
                        tabFrame.setBackgroundAt(cnt++, Color.green);
                    }
                }

                MainFrame.getInstance().setTabFrame(tabFrame);

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
