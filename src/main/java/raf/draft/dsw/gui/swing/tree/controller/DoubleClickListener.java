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
            e.consume();
            Icon icon = new TabFrame().loadIcon("/images/room.png");
            DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();

            if(selected instanceof Project) {
                MainFrame.getInstance().getTabFrame().removeAll();
                ArrayList<DraftNode> projectNodes = ((DraftNodeComposite) selected).getChildren();


                int cnt = 0;

                for(DraftNode node : projectNodes) {
                    if(node instanceof Building) {
                        for(DraftNode room : ((Building) node).getChildren()) {
                            Room r = (Room) room;
                            MainFrame.getInstance().getTabFrame().addTab(room.getName(), icon, r.getTab());
//                            MainFrame.getInstance().getTabFrame().setBackground(((Building)(node)).getColor());
                        }
                    }
                    if(node instanceof Room) {
                        MainFrame.getInstance().getTabFrame().addTab(node.getName(), icon, ((Room) node).getTab());
//                        MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt++, ((Building)(node)).getColor());
                    }
                }

                MainFrame.getInstance().setTabFrame(MainFrame.getInstance().getTabFrame());

            }
            if(selected instanceof Room) {
                Room room = (Room) selected;
                MainFrame.getInstance().getTabFrame().removeAll();
                MainFrame.getInstance().getTabFrame().addTab(room.getName(), icon, room.getTab());

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
