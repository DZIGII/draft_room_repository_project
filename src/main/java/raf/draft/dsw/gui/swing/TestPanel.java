package raf.draft.dsw.gui.swing;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class TestPanel extends JPanel {

    private String lbl;
    private JLabel jl;

    public TestPanel(String lbl) {
        this.lbl = lbl;
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("test");
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
        init();
        showel();
    }

    void init() {
        jl = new JLabel(lbl);
    }

    void showel() {
        setLayout(new BorderLayout());
        add(jl, BorderLayout.CENTER);
    }

    public String getLbl() {
        return lbl;
    }

    public void setLbl(String lbl) {
        this.lbl = lbl;
    }

    public JLabel getJl() {
        return jl;
    }

    public void setJl(JLabel jl) {
        this.jl = jl;
    }
}
