package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.SetRoomSize;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RoomDimensionsFrame extends JFrame {

    private Room room;

    private JLabel succses = new JLabel("");
    private JLabel width = new JLabel();
    private JLabel height = new JLabel();

    private JTextField widthField = new JTextField();
    private JTextField heightField = new JTextField();

    private JButton saveBtn = new JButton("Set change");
    private JButton exitBtn = new JButton("Exit");



    public RoomDimensionsFrame(Room room) throws HeadlessException {
        this.room = room;
        initialize();
        showel();
        controller();
    }


    public void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 3, screenHeight / 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Set room witdh/height");

        width.setText("Widht: ");
        height.setText("Height: ");
    }

    public void showel() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(5, 5));

        jp.setBorder(new EmptyBorder(20, 20, 20, 20)); // Padding

        //style buttons
        saveBtn.setBackground(new Color(2, 163, 61));
        saveBtn.setForeground(Color.white);
//        saveBtn.setBorder(new EmptyBorder(5, 5, 5, 5));

        exitBtn.setBackground(new Color(218, 55, 50));
        exitBtn.setForeground(Color.white);
//        exitBtn.setBorder(new EmptyBorder(5, 5, 5, 5));

        // Podesavanja koja omogucavaju da se promeni boja dugmeta
        saveBtn.setOpaque(true);
        saveBtn.setBorderPainted(false);
        saveBtn.setContentAreaFilled(true);

        exitBtn.setOpaque(true);
        exitBtn.setBorderPainted(false);
        exitBtn.setContentAreaFilled(true);

        jp.add(width);
        jp.add(widthField);
        jp.add(height);
        jp.add(heightField);
        jp.add(saveBtn);
        jp.add(exitBtn);
        jp.add(succses);

        this.add(jp);

        setVisible(true);
    }

    void controller() {
        exitBtn.addActionListener(e -> dispose());
        saveBtn.addMouseListener(new SetRoomSize(room, widthField, heightField, this));
    }

    public JTextField getWidthField() {
        return widthField;
    }

    public void setWidthField(JTextField widthField) {
        this.widthField = widthField;
    }

    public JTextField getHeightField() {
        return heightField;
    }

    public void setHeightField(JTextField heightField) {
        this.heightField = heightField;
    }

    public JLabel getSuccses() {
        return succses;
    }

    public void setSuccses(JLabel succses) {
        this.succses = succses;
    }

}
