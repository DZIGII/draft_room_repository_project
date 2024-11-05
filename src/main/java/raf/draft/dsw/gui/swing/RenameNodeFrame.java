package raf.draft.dsw.gui.swing;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;

public class RenameNodeFrame extends JFrame {
    private JLabel newNodeNameLabel = new JLabel("");;
    private JTextField newNodeNameTF = new JTextField("");

    private JButton saveBtn = new JButton("Save change");
    private JButton exitBtn = new JButton("Exit");

    private JLabel succses = new JLabel("");

    public RenameNodeFrame() {
        initialize();
        showel();
        controller();
    }

    public void initialize() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 4, screenHeight / 5);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Rename");

        newNodeNameLabel.setText("New node name: ");
    }

    public void showel() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(3, 3));

        jp.setBorder(new EmptyBorder(25, 20, 1, 20)); // Padding

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

        jp.add(newNodeNameLabel);
        jp.add(newNodeNameTF);
        jp.add(saveBtn);
        jp.add(exitBtn);
        jp.add(succses);

        this.add(jp);

        setVisible(true);
    }

    void controller() {
        saveBtn.addActionListener(MainFrame.getInstance().getActionManager().getRenameSaveAction());
        exitBtn.addActionListener(MainFrame.getInstance().getActionManager().getRenameExitAction());
    }

    public JLabel getNewNodeNameLabel() {
        return newNodeNameLabel;
    }

    public void setNewNodeNameLabel(JLabel newNodeNameLabel) {
        this.newNodeNameLabel = newNodeNameLabel;
    }

    public JTextField getNewNodeNameTF() {
        return newNodeNameTF;
    }

    public void setNewNodeNameTF(JTextField newNodeNameTF) {
        this.newNodeNameTF = newNodeNameTF;
    }

    public JLabel getSuccses() {
        return succses;
    }

    public void setSuccses(JLabel succses) {
        this.succses = succses;
    }
}
