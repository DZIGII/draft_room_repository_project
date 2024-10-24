package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.AboutUsAction;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AboutUsFrame extends JFrame {

    JLabel student1;
    JLabel student2;

    ImageIcon studentIcon1;
    ImageIcon studentIcon2;

    JLabel imageLabel1;
    JLabel imageLabel2;


    public AboutUsFrame() {
        initElements();
        showElements();
    }


    public void initElements() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 2, screenHeight / 2);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("About students");

        student1 = new JLabel("Nikola Raskovic RN 101/2024");
        student2 = new JLabel("Nikola Jovic SI 101/2023");

        studentIcon1 = loadIcon("/images/nikolaraskovic.png");
        studentIcon2 = loadIcon("/images/nikolajovic.png");

        imageLabel1 = new JLabel(studentIcon1);
        imageLabel2 = new JLabel(studentIcon2);
    }

    public void showElements() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2, 2));
        //jp.add(student1, BorderLayout.EAST);
        //jp.add(student2, BorderLayout.SOUTH);
        jp.add(imageLabel1);
        jp.add(student1);
        jp.add(imageLabel2);
        jp.add(student2);


       this.add(jp);

        setVisible(true);
    }

    public ImageIcon loadIcon(String path) {
        ImageIcon icon = null;
        URL ImageURL = getClass().getResource(path);
        if(ImageURL != null)
        {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else
        {
            System.err.println("File not found");
        }
        return icon;
    }

}
