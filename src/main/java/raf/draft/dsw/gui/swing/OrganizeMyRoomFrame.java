package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.lang.model.element.Element;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class OrganizeMyRoomFrame extends JFrame {
    JLabel widthLabel = new JLabel("Width:");
    JLabel heightLabel = new JLabel("Height:");
    JLabel comboBoxLabel = new JLabel("ComboBox:");
    JLabel elementsLabel = new JLabel("Elements:");

    JTextField widthTF = new JTextField();
    JTextField heightTF = new JTextField();
    JComboBox<String> comboBox = new JComboBox<String>();

    JButton inputButton = new JButton("Input");

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
        comboBox.addItem("RoomElement");
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
        jp.add((new Label("")), gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        jp.add((new Label("")), gbc);

        gbc.gridx = 3;
        gbc.gridy = 2;
        jp.add((inputButton), gbc);

        this.add(jp);
    }

    void controller() {
        //saveBtn.addActionListener(MainFrame.getInstance().getActionManager().getEditProjectSaveAction());
    }
}
