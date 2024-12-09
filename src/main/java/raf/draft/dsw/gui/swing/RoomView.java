package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.AddDimensionAction;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.controller.state.StateManager;
import raf.draft.dsw.model.messages.Message;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class RoomView extends JPanel implements ISubscriber {

    private Room room;
    private String roomName;
    private JLabel jLabel;
    private List<Painter> painters;

    private StateManager stateManager = new StateManager();

    public RoomView(String roomName, Room room) {
        this.roomName = roomName;
        this.room = room;
        this.painters = new ArrayList<>();
        this.addMouseListener(new AddDimensionAction(room));
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                stateManager.getCurrentState().log();
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
        });
        initialize();
        showel();
    }

    public void initialize() {
        jLabel = new JLabel(roomName);
    }

    public void showel() {
        setLayout(new BorderLayout());
        add(createContentPanel(), BorderLayout.CENTER);
    }

    private JPanel createContentPanel() {
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Content for: " + (roomName != null ? roomName : "Unnamed Room"));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 14));

        panel.add(label, BorderLayout.CENTER);
        return panel;
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
                int cnt = 0;

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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D graphics = (Graphics2D) g;

        Double panelRatio = (double)this.getWidth()/ (double) this.getHeight();
        Double roomWidthHightRatio = ((double) this.room.getWidth() / (double) this.room.getHeight());


        if(panelRatio > roomWidthHightRatio) {
            graphics.drawRect((int) (this.getWidth()*5/100 + this.getWidth()*9/10*((panelRatio-roomWidthHightRatio)/2/panelRatio)), this.getHeight()*5/100, (int) (this.getWidth()*9/10*roomWidthHightRatio/panelRatio), this.getHeight()*90/100);

        }else {
            graphics.drawRect(this.getWidth()*5/100, (int) (this.getHeight()*5/100 + this.getHeight()*9/10*((roomWidthHightRatio-panelRatio)/2/roomWidthHightRatio)), this.getWidth()*90/100, (int) (this.getHeight()*9/10*panelRatio/roomWidthHightRatio));
        }




    }

    public void addElement(RoomElement roomElement) {

    }

    public void startAddElemetState() {
        this.stateManager.setAddElementState();
    }

    public void startCopyPasteState() {
        this.stateManager.setCopyPasteState();
    }

    public void startDeleteState() {
        this.stateManager.setDeleteState();
    }

    public void startEditRoomState() {
        this.stateManager.setEditRoomState();
    }

    public void startEditState() {
        this.stateManager.setEditState();
    }

    public void startMoveState() {
        this.stateManager.setMoveState();
    }

    public void startResizeState() {
        this.stateManager.setResizeState();
    }

    public void startRotateState() {
        this.stateManager.setRoteteState();
    }

    public void startSelectState() {
        this.stateManager.setSelectState();
    }

    public void startZoomState() {
        this.stateManager.setZoomState();
    }

    public void paintBed() {

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
