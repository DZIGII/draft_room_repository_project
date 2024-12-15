package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BathtubPainter;
import raf.draft.dsw.gui.swing.painter.BoilerPainter;
import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Boiler;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddBoilerState implements State {

    @Override
    public void log() {

    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {
        JPanel panel = new JPanel(new GridLayout(2, 2));
        JLabel widthLabel = new JLabel("Width:");
        JTextField widthField = new JTextField();

        panel.add(widthLabel);
        panel.add(widthField);

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter dimensions of door", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double width = Double.parseDouble(widthField.getText());

                double roomWidth = roomView.getRoom().getWidth();
                double roomHeight = roomView.getRoom().getHeight();

                double panelWidth = roomView.getWidth();
                double panelHeight = roomView.getHeight();

                double panelRatio = panelWidth / panelHeight;
                double roomRatio = roomWidth / roomHeight;

                double scaledWidth, adjustedRoomWidth;

                if (panelRatio > roomRatio) {
                    adjustedRoomWidth = panelWidth * 0.9 * roomRatio / panelRatio;

                    double scaleX = adjustedRoomWidth / roomWidth;

                    scaledWidth = width * scaleX;
                } else {
                    adjustedRoomWidth = panelWidth * 0.9;

                    double scaleX = adjustedRoomWidth / roomWidth;

                    scaledWidth = width * scaleX;
                }

                if(adjustedRoomWidth<scaledWidth || clickPoint.getX() + scaledWidth > roomView.getPoint().getX() + adjustedRoomWidth || clickPoint.getY() + scaledWidth > roomView.getPoint().getY() + adjustedRoomWidth || clickPoint.getX() < roomView.getPoint().getX() || clickPoint.getY() < roomView.getPoint().getY()) {
                    JOptionPane.showMessageDialog(null, "Element exceeds room boundaries!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Dimension2D dimension = new Dimension();
                dimension.setSize(scaledWidth, scaledWidth);

                Boiler boiler = new Boiler("Boiler", clickPoint, dimension);
                boiler.setLocation(clickPoint);
                boiler.setDimension(scaledWidth, scaledWidth);

                BoilerPainter boilerPainter = new BoilerPainter(boiler);
                roomView.addElement(boilerPainter);
                roomView.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert valid dimensions!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e, RoomView roomView) {

    }

    @Override
    public void mouseDragged(MouseEvent e, RoomView roomView) {

    }

    @Override
    public void mouseRelease(MouseEvent e, RoomView roomView) {

    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, RoomView roomView) {

    }

    @Override
    public void copy() {

    }
}
