package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.SetRoomSize;
import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.controller.state.concrete.*;
import raf.draft.dsw.gui.swing.painter.*;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.factories.BathtabFactory;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.model.structures.roomElements.*;

import javax.lang.model.element.Element;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Dimension2D;
import java.util.ArrayList;

public class OrganizeMyRoomFrame extends JFrame {
    JLabel widthLabel = new JLabel("Width:");
    JLabel heightLabel = new JLabel("Height:");
    JLabel comboBoxLabel = new JLabel("ComboBox:");
    JLabel elementsLabel = new JLabel("Elements:");

    JTextField widthTF = new JTextField();
    JTextField heightTF = new JTextField();
    JComboBox<String> comboBox = new JComboBox<String>();

    JButton addElementButton = new JButton("Add element");
    JButton removeElementButton = new JButton("Remove element");
    JButton organizeMyRoomButton = new JButton("Organize my room");

    private ArrayList<RoomElement> elements = new ArrayList<>();
    private ArrayList<Point> pointers = new ArrayList<>();
    private ArrayList<Dimension2D> dimensions = new ArrayList<>();
    JList<RoomElement> elemntsList = new JList<RoomElement>();

    public OrganizeMyRoomFrame() throws HeadlessException {
        initialize();
        showel();
        controller();
    }


    public void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 3, screenHeight / 3);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Organize my room");
    }

    public void showel() {
        JPanel jp = new JPanel(new GridBagLayout());
        jp.setPreferredSize(new Dimension(this.getWidth(), this.getHeight()));
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        jp.add((widthLabel), gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        jp.add((heightLabel), gbc);

        gbc.gridx = 2;
        gbc.gridy = 0;
        jp.add((comboBoxLabel), gbc);

        gbc.gridx = 3;
        gbc.gridy = 0;
        jp.add((elementsLabel), gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        widthTF.setPreferredSize(new Dimension(150, 30));
        jp.add(widthTF, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.NORTH;
        heightTF.setPreferredSize(new Dimension(150, 30));
        jp.add(heightTF, gbc);

        gbc.gridx = 2;
        gbc.gridy = 1;
        comboBox.addItem("Bathtub");
        comboBox.addItem("Bed");
        comboBox.addItem("Boiler");
        comboBox.addItem("Closet");
        comboBox.addItem("Door");
        comboBox.addItem("Sink");
        comboBox.addItem("Table");
        comboBox.addItem("Toilet");
        comboBox.addItem("Washing machine");
        comboBox.setPreferredSize(new Dimension(150, 30));
        jp.add(comboBox, gbc);

        gbc.gridx = 3;
        gbc.gridy = 1;
        elemntsList.setPreferredSize(new Dimension(150, 300));
        gbc.fill = GridBagConstraints.VERTICAL;
        jp.add(elemntsList, gbc);


        gbc.gridx = 0;
        gbc.gridy = 2;
        jp.add((new Label("")), gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        jp.add(addElementButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        jp.add((removeElementButton), gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        jp.add((organizeMyRoomButton), gbc);

        this.add(jp);
    }

    void controller() {
        addElementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    int widthElement = Integer.parseInt(widthTF.getText());
                    int heightElement = Integer.parseInt(heightTF.getText());
                    String comboBoxElement = comboBox.getSelectedItem().toString();

                    RoomElement roomElement = null;

                    switch (comboBoxElement) {
                        case "Bathtub":
                            roomElement = new Bathtub("Bathtub", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Bed":
                            roomElement = new Bed("Bed", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Boiler":
                            roomElement = new Boiler("Boiler", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Closet":
                            roomElement = new Closet("Closet", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Door":
                            roomElement = new Door("Door", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Sink":
                            roomElement = new Sink("Sink", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Table":
                            roomElement = new Table("Table", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Toilet":
                            roomElement = new Toilet("Toilet", null,new Dimension(widthElement, heightElement));
                            break;
                        case "Washing machine":
                            roomElement = new WashingMachine("Washing machine", null,new Dimension(widthElement, heightElement));
                            break;
                        default:
                            roomElement = new Bed("Bed", null,new Dimension(widthElement, heightElement));
                    }

                    elements.add(roomElement);

                    DefaultListModel<RoomElement> listModel = new DefaultListModel<>();
                    for (RoomElement el : elements) {
                        listModel.addElement(el);
                    }
                    elemntsList.setModel(listModel);

                } catch (NumberFormatException ex) {
                    MainFrame.getInstance().getMessageGenerator().generateMessage("Width and Height must be integers!", "Error");
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        removeElementButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                RoomElement selectedElement = elemntsList.getSelectedValue();
                if (selectedElement != null) {
                    elements.remove(selectedElement);

                    DefaultListModel<RoomElement> listModel = new DefaultListModel<>();
                    for (RoomElement el : elements) {
                        listModel.addElement(el);
                    }
                    elemntsList.setModel(listModel);
                } else {
                    MainFrame.getInstance().getMessageGenerator().generateMessage("Please select an element to remove!", "Error");
                }
            }
        });


        organizeMyRoomButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JTextField widthField = new JTextField();
                JTextField heightField = new JTextField();
                Object[] message = {
                        "Room Width:", widthField,
                        "Room Height:", heightField
                };

                int option = JOptionPane.showConfirmDialog(
                        null,
                        message,
                        "Enter Room Dimensions",
                        JOptionPane.OK_CANCEL_OPTION
                );

                if (option == JOptionPane.OK_OPTION) {
                    try {
                        int roomWidth = Integer.parseInt(widthField.getText());
                        int roomHeight = Integer.parseInt(heightField.getText());

                        if (roomWidth <= 0 || roomHeight <= 0) {
                            throw new NumberFormatException("Dimensions must be positive integers!");
                        }

                        DraftTreeItem selected = (DraftTreeItem) MainFrame.getInstance().getDraftTree().getSelectedNode();

                        Room newRoom = new Room("Organize My Room", selected.getDraftNode());
                        newRoom.setWidth(roomWidth);
                        newRoom.setHeight(roomHeight);
                        newRoom.getTab().removeAll();
                        newRoom.getTab().revalidate();
                        newRoom.getTab().repaint();

                        selected.add(new DraftTreeItem(newRoom));
                        ((DraftNodeComposite) selected.getDraftNode()).addChild(newRoom);
                        MainFrame.getInstance().getDraftTree().getTreeView().expandPath(MainFrame.getInstance().getDraftTree().getTreeView().getSelectionPath());
                        SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());

                        MainFrame.getInstance().getTabFrame().add(newRoom.getTab());

                        SwingUtilities.invokeLater(() -> {
                            double maxWidth = -1;
                            double maxHeight = -1;

                            double maxWidthScaled = -1;
                            double maxHeightScaled = -1;

                            double panelWidth = newRoom.getTab().getWidth();
                            int panelHeight = newRoom.getTab().getHeight();

                            double panelRatio = panelWidth / panelHeight;
                            double roomRatio = roomWidth / roomHeight;

                            double adjustedRoomWidth, adjustedRoomHeight, scaledX, scaledY;

                            for (RoomElement el : elements) {
                                if (el.getDimension().getWidth() > maxWidth) {
                                    maxWidth = el.getDimension().getWidth();
                                }
                                if (el.getDimension().getHeight() > maxHeight) {
                                    maxHeight = el.getDimension().getHeight();
                                }
                                if (panelRatio > roomRatio) {
                                    adjustedRoomWidth = panelWidth * 0.9 * roomRatio / panelRatio;
                                    adjustedRoomHeight = panelHeight * 0.9;

                                    double scaleX = adjustedRoomWidth / roomWidth;
                                    double scaleY = adjustedRoomHeight / roomHeight;

                                    el.setDimension(el.getDimension().getWidth() * scaleX,el.getDimension().getHeight() *scaleY);
                                    dimensions.add(el.getDimension());

                                } else {
                                    adjustedRoomWidth = panelWidth * 0.9;
                                    adjustedRoomHeight = panelHeight * 0.9 * panelRatio / roomRatio;

                                    double scaleX = adjustedRoomWidth / roomWidth;
                                    double scaleY = adjustedRoomHeight / roomHeight;

                                    el.setDimension(el.getDimension().getWidth() * scaleX,el.getDimension().getHeight() *scaleY);
                                    dimensions.add(el.getDimension());
                                }

                                if (el.getDimension().getWidth() > maxWidthScaled) {
                                    maxWidthScaled = el.getDimension().getWidth();
                                }
                                if (el.getDimension().getHeight() > maxHeightScaled) {
                                    maxHeightScaled = el.getDimension().getHeight();
                                }
                            }

                            int i = roomHeight / (int) maxHeight;
                            int j = roomWidth / (int) maxWidth;

                            if (i <= 0 || j <= 0) {
                                MainFrame.getInstance().getMessageGenerator().generateMessage("Room is too small to fit even one field!", "Error");
                                return;
                            }

                            int maxElements = i * j;
                            if (elements.size() > maxElements) {
                                MainFrame.getInstance().getMessageGenerator().generateMessage("Too many elements! Cannot fit into the room.", "Error");
                                return;
                            }

                            panelRatio = (double) newRoom.getTab().getWidth() / (double) newRoom.getTab().getHeight();
                            roomRatio = (double) newRoom.getWidth() / (double) newRoom.getHeight();
                            Point startPoint;
                            Point endPoint;

                            if (panelRatio > roomRatio) {
                                double offsetX = newRoom.getTab().getWidth() * 0.05 +
                                        newRoom.getTab().getWidth() * 0.9 * ((panelRatio - roomRatio) / (2 * panelRatio));
                                startPoint = new Point(
                                        (int) offsetX,
                                        (int) (newRoom.getTab().getHeight() * 0.05)
                                );
                                endPoint = new Point(
                                        startPoint.x + (int)(newRoom.getTab().getWidth() * 9 / 10 * roomRatio / panelRatio),
                                        startPoint.y + (int)(newRoom.getTab().getHeight() * 90 / 100)
                                );
                            } else {
                                double offsetY = newRoom.getTab().getHeight() * 0.05 +
                                        newRoom.getTab().getHeight() * 0.9 * ((roomRatio - panelRatio) / (2 * roomRatio));
                                startPoint = new Point(
                                        (int) (newRoom.getTab().getWidth() * 0.05),
                                        (int) offsetY
                                );
                                double scaledHeight = newRoom.getHeight() * 0.9 * panelRatio / roomRatio;
                                endPoint = new Point(
                                        startPoint.x + newRoom.getTab().getWidth() * 90 / 100,
                                        startPoint.y + (int)(newRoom.getTab().getHeight() * 9 / 10 * panelRatio / roomRatio)
                                );
                            }

                            boolean[][] visited = new boolean[i][j];

                            int row = 0, col = 0;
                            int dRow[] = {0, 1, 0, -1};
                            int dCol[] = {1, 0, -1, 0};
                            int dir = 0;

                            for (int step = 0; step < dimensions.size(); step++) {
                                if((j>1 && col==j-1) && (i>1 && row==i-1))
                                    pointers.add(new Point((int) (startPoint.getX()+endPoint.getX()-startPoint.getX()-dimensions.get(step).getWidth()), (int) (startPoint.getY()+ endPoint.getY()-startPoint.getY()-dimensions.get(step).getHeight())));
                                else if(j>1 && col==j-1)
                                    pointers.add(new Point((int) (startPoint.getX()+ endPoint.getX()-startPoint.getX()-dimensions.get(step).getWidth()), (int) (startPoint.getY()+row*maxHeightScaled)));
                                else if(i>1 && row==i-1)
                                    pointers.add(new Point((int) (startPoint.getX()+col*maxWidthScaled), (int) (startPoint.getY()+ endPoint.getY()-startPoint.getY()-dimensions.get(step).getHeight())));
                                else
                                    pointers.add(new Point((int) (startPoint.getX()+col*maxWidthScaled), (int) (startPoint.getY()+row*maxHeightScaled)));
                                visited[row][col] = true;

                                int nextRow = row + dRow[dir];
                                int nextCol = col + dCol[dir];

                                if (nextRow >= 0 && nextRow < i && nextCol >= 0 && nextCol < j && !visited[nextRow][nextCol]) {
                                    row = nextRow;
                                    col = nextCol;
                                } else {
                                    dir = (dir + 1) % 4;
                                    row += dRow[dir];
                                    col += dCol[dir];
                                }
                            }

                            int cnt=0;
                            for(RoomElement el : elements) {
                                ElementPainter elp;
                                el.setLocation(pointers.get(cnt));
                                if(el instanceof Bed)
                                {
                                    elp = new BedPainter((Bed) el);

                                }
                                else if (el instanceof Sink) {
                                    elp = new SinkPainter((Sink) el);
                                }
                                else if (el instanceof WashingMachine) {
                                    elp = new WashingMachinePainter((WashingMachine) el);
                                }
                                else if (el instanceof Bathtub) {
                                    elp = new BathtubPainter((Bathtub) el);
                                }
                                else if (el instanceof Boiler) {
                                    elp = new BoilerPainter((Boiler) el);
                                }
                                else if (el instanceof Closet) {
                                    elp = new ClosetPainter((Closet) el);
                                }
                                else if (el instanceof Door) {
                                    elp = new DoorPainter((Door) el);
                                }
                                else if (el instanceof Table) {
                                    elp = new TablePainter((Table) el);
                                }
                                else if (el instanceof Toilet) {
                                    elp = new ToiletPainter((Toilet) el);
                                }
                                else{
                                    continue;
                                }
                                elp.setSelected(el,false);
                                newRoom.getTab().addElement(elp);
                                newRoom.getTab().repaint();
                                cnt++;

                                DraftTreeItem parentItem = findTreeItemForRoom((DraftTreeItem) MainFrame.getInstance().getDraftTree().getTreeView().getModel().getRoot(), newRoom);
                                parentItem.add(new DraftTreeItem(el));
                                newRoom.addChild(el);
                                MainFrame.getInstance().getDraftTree().getTreeView().expandPath(MainFrame.getInstance().getDraftTree().getTreeView().getSelectionPath());
                                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());
                            }
                        });

                        dispose();

                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(
                                null,
                                "Invalid dimensions! Please enter positive integers.",
                                "Error",
                                JOptionPane.ERROR_MESSAGE
                        );
                    }
                }
            }
        });
    }

    public DraftTreeItem findTreeItemForRoom(DraftTreeItem root, Room room) {
        if (root.getDraftNode() instanceof Room && root.getDraftNode().equals(room)) {
            return root;
        }

        for (int i = 0; i < root.getChildCount(); i++) {
            DraftTreeItem child = (DraftTreeItem) root.getChildAt(i);
            DraftTreeItem found = findTreeItemForRoom(child, room);
            if (found != null) {
                return found;
            }
        }

        return null;
    }

    public JLabel getWidthLabel() {
        return widthLabel;
    }

    public void setWidthLabel(JLabel widthLabel) {
        this.widthLabel = widthLabel;
    }

    public JLabel getHeightLabel() {
        return heightLabel;
    }

    public void setHeightLabel(JLabel heightLabel) {
        this.heightLabel = heightLabel;
    }

    public JLabel getComboBoxLabel() {
        return comboBoxLabel;
    }

    public void setComboBoxLabel(JLabel comboBoxLabel) {
        this.comboBoxLabel = comboBoxLabel;
    }

    public JLabel getElementsLabel() {
        return elementsLabel;
    }

    public void setElementsLabel(JLabel elementsLabel) {
        this.elementsLabel = elementsLabel;
    }

    public JTextField getWidthTF() {
        return widthTF;
    }

    public void setWidthTF(JTextField widthTF) {
        this.widthTF = widthTF;
    }

    public JTextField getHeightTF() {
        return heightTF;
    }

    public void setHeightTF(JTextField heightTF) {
        this.heightTF = heightTF;
    }

    public JComboBox<String> getComboBox() {
        return comboBox;
    }

    public void setComboBox(JComboBox<String> comboBox) {
        this.comboBox = comboBox;
    }

    public JButton getAddElementButton() {
        return addElementButton;
    }

    public void setAddElementButton(JButton addElementButton) {
        this.addElementButton = addElementButton;
    }

    public JButton getRemoveElementButton() {
        return removeElementButton;
    }

    public void setRemoveElementButton(JButton removeElementButton) {
        this.removeElementButton = removeElementButton;
    }

    public JButton getOrganizeMyRoomButton() {
        return organizeMyRoomButton;
    }

    public void setOrganizeMyRoomButton(JButton organizeMyRoomButton) {
        this.organizeMyRoomButton = organizeMyRoomButton;
    }

    public ArrayList<RoomElement> getElements() {
        return elements;
    }

    public void setElements(ArrayList<RoomElement> elements) {
        this.elements = elements;
    }

    public JList<RoomElement> getElemntsList() {
        return elemntsList;
    }

    public void setElemntsList(JList<RoomElement> elemntsList) {
        this.elemntsList = elemntsList;
    }
}
