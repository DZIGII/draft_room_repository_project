package raf.draft.dsw.gui.swing;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditProjectFrame extends JFrame {

    JLabel succses = new JLabel("");
    JLabel newNamelbl = new JLabel();
    JLabel newAuthorlbl = new JLabel();
    JLabel newPathlbl = new JLabel();

    JTextField newName = new JTextField();
    JTextField newAuthor = new JTextField();
    JTextField newPath = new JTextField();

    JButton saveBtn = new JButton("Sacuvaj promenu");
    JButton exitBtn = new JButton("Izlaz");

    private Project node;

    public EditProjectFrame(DraftNode node) throws HeadlessException {
        this.node = (Project) node;
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
        setTitle("Edit Project");

        newNamelbl.setText("Novi naziv:");
        newAuthorlbl.setText("Novi autor:");
        newPathlbl.setText("Nova putanja:");
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

        jp.add(newNamelbl);
        jp.add(newName);
        jp.add(newAuthorlbl);
        jp.add(newAuthor);
        jp.add(newPathlbl);
        jp.add(newPath);
        jp.add(saveBtn);
        jp.add(exitBtn);
        jp.add(succses);

        this.add(jp);

        setVisible(true);
    }

    void controller() {
        saveBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                node.setProjectName(newName.getText());
                node.setCreatorName(newAuthor.getText());
                node.setPathToProjectResources(newPath.getText());

                newName.setText("");
                newAuthor.setText("");
                newPath.setText("");
                succses.setText("Uspesno ste sacuvali promenu");
            }
        });
        exitBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
    }

}
