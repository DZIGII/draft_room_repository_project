package raf.draft.dsw.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.net.URL;

public class TabFrame extends JPanel {

    public String title;
    public String iconPath;


    public TabFrame(String title, String iconPath) {
        this.title = title;
        this.iconPath = iconPath;
        show();
    }

    public TabFrame() {

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

}
