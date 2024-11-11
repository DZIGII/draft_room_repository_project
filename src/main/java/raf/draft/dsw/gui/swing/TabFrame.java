package raf.draft.dsw.gui.swing;

import com.sun.tools.javac.Main;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;

public class TabFrame extends JPanel implements ISubscriber {

    public String title;
    public Room room;
    public String roomName;

    public TabFrame(String title) {
        show();
    }

    public TabFrame() {
        show();
    }

    public void show() {
        setLayout(new BorderLayout());
        add(makeTextPanel("Content for " + title), BorderLayout.CENTER);
    }

    public Icon loadIcon(String path) {
        Icon icon = null;
        URL ImageURL = getClass().getResource(path);
        if(ImageURL != null)
        {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(30, 30, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else
        {
            System.err.println("File not found");
        }
        return icon;
    };

    public JComponent makeTextPanel(String text) {
        JPanel panel = new JPanel(false);
        JLabel filler = new JLabel(text);
        filler.setHorizontalAlignment(JLabel.CENTER);
        panel.setLayout(new GridLayout(1, 1));
        panel.add(filler);
        return panel;
    }

    @Override
    public void recive(Object notification) {
        String update = (String) notification;
        if(!roomName.equals(room.getName())) {
            for(int i = 0;i < MainFrame.getInstance().getTabFrame().getTabCount(); i++) {
                if(MainFrame.getInstance().getTabFrame().getTitleAt(i).equals(roomName)) {
                    MainFrame.getInstance().getTabFrame().remove(i);
                    MainFrame.getInstance().getTabFrame().addTab(update, this);
                }
            }
            roomName = update;
        }
    }

    @Override
    public void nodeDeleted() {
        for (int i = 0; i < MainFrame.getInstance().getTabFrame().getTabCount(); i++) {
            if (MainFrame.getInstance().getTabFrame().getTitleAt(i).equals(roomName)) {
                MainFrame.getInstance().getTabFrame().remove(i);
                break;
            }
        }
    }

    @Override
    public void nodeAdded() {
        DraftNode selected = MainFrame.getInstance().getDraftTree().getSelectedNode().getDraftNode();
        if (selected instanceof Project) {
            updateTabsForProject((Project) selected);
        } else if (selected instanceof Building) {
            updateTabsForProject((Project) selected.getParent());
        }
    }

    @Override
    public void update(Message message) {

    }

    public void updateTabsForProject(Project project) {

        //garantuje da će se kod izvršiti u pravom trenutku i na pravom mestu — u EDT-u.

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainFrame.getInstance().getTabFrame().removeAll();
                int cnt =0;

                if (project == null) {
                    return;
                }

                Icon icon = loadIcon("/images/room.png");

                for (DraftNode child : project.getChildren()) {
                    if (child instanceof Building) {
                        Building building = (Building) child;
                        for (DraftNode roomNode : building.getChildren()) {
                            if (roomNode instanceof Room) {
                                MainFrame.getInstance().getTabFrame().addTab(roomNode.getName(), icon, ((Room) roomNode).getTab());
                                MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt, building.getColor());
                            }
                            cnt++;
                        }
                    } else if (child instanceof Room) {
                        MainFrame.getInstance().getTabFrame().addTab(child.getName(), icon, ((Room) child).getTab());
                        MainFrame.getInstance().getTabFrame().setBackgroundAt(cnt, ((Room) child).getColor());
                        cnt++;
                    }
                }

            }
        });
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}
