package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.TabFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.nodes.Leaf;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;

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
//                MainFrame.getInstance().getTabFrame().removeAll();
                ArrayList<DraftNode> projectNodes = ((Project) selected).getChildren();
                JTabbedPane tabFrame = new JTabbedPane();
                Icon icon = new TabFrame().loadIcon("/images/room.png");

                int cnt = 0;

                for(DraftNode node : projectNodes) {
                    if(node instanceof Building) {
                        Building b = (Building) node;
                        for(DraftNode room : b.getChildren()) {
                            Room r = (Room) room;
                            MainFrame.getInstance().getTabFrame().addTab(r.getName(), r.getTab());
//                            tabFrame.addTab(room.getName(), icon, new TabFrame());
//                            tabFrame.setBackgroundAt(cnt++, ((Building)(selected.getParent())).getColor());
                        }
                    }
                    if(node instanceof Room) {
//                       tabFrame.addTab(node.getName(), icon, new TabFrame());
//                       tabFrame.setBackgroundAt(cnt++, Color.green);
                    }
                }

                MainFrame.getInstance().setTabFrame(tabFrame);

            }
            if(selected instanceof Room) {
                Room room = (Room) selected;
                MainFrame.getInstance().getTabFrame().removeAll();
                MainFrame.getInstance().getTabFrame().addTab(room.getName(), room.getTab());

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
