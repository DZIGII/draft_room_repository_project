package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BedPainter;
import raf.draft.dsw.gui.swing.painter.DoorPainter;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.Door;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddDoorState implements State {
    @Override
    public void log() {

    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel widthLabel = new JLabel("Width:");
        JTextField widthField = new JTextField();
        JLabel heightLabel = new JLabel("Height:");
        JTextField heightField = new JTextField();

        panel.add(widthLabel);
        panel.add(widthField);
        panel.add(heightLabel);
        panel.add(heightField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter dimensions of door", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());

                Dimension2D dimension = new Dimension();
                dimension.setSize(width, height);

                Door bed = new Door("Door", clickPoint, dimension);
                bed.setLocation(clickPoint);
                bed.setDimension(width, height);

                DoorPainter doorPainter = new DoorPainter(bed);
                roomView.addElement(doorPainter);
                roomView.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Molimo unesite validne brojeve za dimenzije!", "Greška", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public void printDoor(Point2D clickPoint, RoomView roomView) {
        Dimension2D d = new Dimension();
        Door door = new Door("Bed", clickPoint, d);

        door.setLocation(clickPoint);
        door.setDimension(30, 30);
        DoorPainter bedPainter = new DoorPainter(door);

        roomView.addElement(bedPainter);
        roomView.repaint();
    }
}
