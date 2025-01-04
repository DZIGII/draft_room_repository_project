package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.factories.BathtabFactory;
import raf.draft.dsw.model.structures.roomElements.*;

import javax.lang.model.element.Element;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
        jp.add(addElementButton, gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
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
        jp.add((removeElementButton), gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        jp.add((organizeMyRoomButton), gbc);

        this.add(jp);
    }

    void controller() {
        //saveBtn.addActionListener(MainFrame.getInstance().getActionManager().getEditProjectSaveAction());
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
