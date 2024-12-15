package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BedPainter;
import raf.draft.dsw.gui.swing.painter.ClosetPainter;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.Closet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddClosetState implements State {

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

        int result = JOptionPane.showConfirmDialog(null, panel, "Enter dimensions of bed", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            try {
                double width = Double.parseDouble(widthField.getText());
                double height = Double.parseDouble(heightField.getText());

                double roomWidth = roomView.getRoom().getWidth();
                double roomHeight = roomView.getRoom().getHeight();

                double panelWidth = roomView.getWidth();
                double panelHeight = roomView.getHeight();

                double panelRatio = panelWidth / panelHeight;
                double roomRatio = roomWidth / roomHeight;

                double adjustedRoomWidth, adjustedRoomHeight, scaledX, scaledY, scaledWidth, scaledHeight;

                if (panelRatio > roomRatio) {
                    adjustedRoomWidth = panelWidth * 0.9 * roomRatio / panelRatio;
                    adjustedRoomHeight = panelHeight * 0.9;

                    double scaleX = adjustedRoomWidth / roomWidth;
                    double scaleY = adjustedRoomHeight / roomHeight;

                    scaledWidth = width * scaleX;
                    scaledHeight = height * scaleY;
                } else {
                    adjustedRoomWidth = panelWidth * 0.9;
                    adjustedRoomHeight = panelHeight * 0.9 * panelRatio / roomRatio;

                    double scaleX = adjustedRoomWidth / roomWidth;
                    double scaleY = adjustedRoomHeight / roomHeight;

                    scaledWidth = width * scaleX;
                    scaledHeight = height * scaleY;
                }

                if(adjustedRoomWidth<scaledWidth || adjustedRoomHeight<scaledHeight || clickPoint.getX() + scaledWidth > roomView.getPoint().getX() + adjustedRoomWidth || clickPoint.getY() + scaledHeight > roomView.getPoint().getY() + adjustedRoomHeight || clickPoint.getX() < roomView.getPoint().getX() || clickPoint.getY() < roomView.getPoint().getY()) {
                    JOptionPane.showMessageDialog(null, "Element exceeds room boundaries!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Dimension2D dimension = new Dimension();
                dimension.setSize(scaledWidth, scaledHeight);

                Closet closet = new Closet("Closet", clickPoint, dimension);
                closet.setLocation(clickPoint);
                closet.setDimension(scaledWidth, scaledHeight);

                ClosetPainter closetPainter = new ClosetPainter(closet);
                roomView.addElement(closetPainter);
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
