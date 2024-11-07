package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import java.awt.*;
import java.util.ArrayList;

public class Building extends DraftNodeComposite {

    private Color color;

    public Building(String name) {
        super(name);
        color = gentateColor();
    }

    public Building(String name, DraftNode parent) {
        super(name, parent);
    }

    public Building(String name, ArrayList<DraftNode> children) {
        super(name, children);
    }

    public Building(String name, DraftNode parent, ArrayList<DraftNode> children) {
        super(name, parent, children);
    }

    public Color gentateColor() {
        int red = (int) (Math.random() * 256);
        int green = (int) (Math.random() * 256);
        int blue = (int) (Math.random() * 256);

        return new Color(red, green, blue);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
