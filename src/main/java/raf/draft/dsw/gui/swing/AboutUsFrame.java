package raf.draft.dsw.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class AboutUsFrame extends JFrame {

    private JLabel student1;
    private JLabel student2;

    private ImageIcon studentIcon1;
    private ImageIcon studentIcon2;

    private JLabel imageLabel1;
    private JLabel imageLabel2;


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
        student2 = new JLabel("Nikola Jovic SI 63/2023");

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

    public JLabel getStudent1() {
        return student1;
    }

    public void setStudent1(JLabel student1) {
        this.student1 = student1;
    }

    public JLabel getStudent2() {
        return student2;
    }

    public void setStudent2(JLabel student2) {
        this.student2 = student2;
    }

    public ImageIcon getStudentIcon1() {
        return studentIcon1;
    }

    public void setStudentIcon1(ImageIcon studentIcon1) {
        this.studentIcon1 = studentIcon1;
    }

    public ImageIcon getStudentIcon2() {
        return studentIcon2;
    }

    public void setStudentIcon2(ImageIcon studentIcon2) {
        this.studentIcon2 = studentIcon2;
    }

    public JLabel getImageLabel1() {
        return imageLabel1;
    }

    public void setImageLabel1(JLabel imageLabel1) {
        this.imageLabel1 = imageLabel1;
    }

    public JLabel getImageLabel2() {
        return imageLabel2;
    }

    public void setImageLabel2(JLabel imageLabel2) {
        this.imageLabel2 = imageLabel2;
    }
}
