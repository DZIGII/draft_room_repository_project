package raf.draft.dsw.gui.swing.painter;

import raf.draft.dsw.model.structures.roomElements.Closet;

import javax.swing.*;
import java.awt.*;

public class ClosetPainter implements Painter {

    private Closet closet;

    public ClosetPainter(Closet closet) {
        this.closet = closet;
    }

    @Override
    public void paint(Graphics2D g, Object object, int width, int height) {

    }

    public Closet getCloset() {
        return closet;
    }

    public void setCloset(Closet closet) {
        this.closet = closet;
    }

}
