package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
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
        int cnt = 0;
        if (e.getClickCount() == 2) {
            Icon icon = new RoomView().loadIcon("/images/room.png");
            DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();

            if(selected instanceof Project) {
                MainFrame.getInstance().getTabFrame().removeAll();
                ArrayList<DraftNode> projectNodes = ((DraftNodeComposite) selected).getChildren();

                Project project = (Project) selected;
                project.subscribe(MainFrame.getInstance());

                project.select();

                for(DraftNode node : projectNodes) {
                    if(node instanceof Building) {
                        Building building = (Building) node;
                        for(DraftNode room : ((Building) node).getChildren()) {
                            Room r = (Room) room;
                            RoomView roomView = ((Room) room).getTab();
                            roomView.setBackground(((Room) room).getColor());
                            MainFrame.getInstance().getTabFrame().addTab(room.getName(), icon, roomView);
                            MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt, building.getColor());
                            cnt++;
                        }
                    }
                    if(node instanceof Room) {
                        Room room = (Room) node;
                        RoomView roomView = new RoomView(node.getName(), (Room) node);
                        roomView.setBackground(((Room) room).getColor());
                        MainFrame.getInstance().getTabFrame().addTab(node.getName(), icon, roomView);
                        MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt, room.getColor());
                        cnt++;
                    }
                }

                MainFrame.getInstance().setTabFrame(MainFrame.getInstance().getTabFrame());

            }
            else if(selected instanceof Room) {
                MainFrame.getInstance().getTabFrame().removeAll();
                Room room = (Room) selected;
                RoomView roomView = new RoomView(selected.getName(), (Room) selected);
                roomView.setBackground(room.getColor());
                MainFrame.getInstance().getTabFrame().removeAll();
                MainFrame.getInstance().getTabFrame().addTab(room.getName(), icon, roomView);
                MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt, room.getColor());

                if(selected.getParent() instanceof Building) {
                    Project parent = (Project) selected.getParent().getParent();
                    parent.select();
                }
                else
                {
                    Project parent = (Project) selected.getParent();
                    parent.select();
                }

            }
            else if(selected instanceof Building) {
                MainFrame.getInstance().getTabFrame().removeAll();
                Project parent = (Project) selected.getParent();
                parent.select();
                for(DraftNode room : ((Building) selected).getChildren()) {
                    Room r = (Room) room;
                    RoomView roomView = new RoomView(room.getName(), (Room) room);
                    roomView.setBackground(((Room) room).getColor());
                    MainFrame.getInstance().getTabFrame().addTab(room.getName(), icon, roomView);
                    MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt, ((Building) selected).getColor());
                    cnt++;
                }

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
