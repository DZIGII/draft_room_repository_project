package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.DoorPainter;
import raf.draft.dsw.gui.swing.painter.SinkPainter;
import raf.draft.dsw.model.structures.roomElements.Door;
import raf.draft.dsw.model.structures.roomElements.Sink;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddSinkState implements State {
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

                double scaledWidth;

                if (panelRatio > roomRatio) {
                    double adjustedRoomWidth = panelWidth * 0.9 * roomRatio / panelRatio;

                    double scaleX = adjustedRoomWidth / roomWidth;

                    scaledWidth = width * scaleX;
                } else {
                    double adjustedRoomWidth = panelWidth * 0.9;

                    double scaleX = adjustedRoomWidth / roomWidth;

                    scaledWidth = width * scaleX;
                }

                Dimension2D dimension = new Dimension();
                dimension.setSize(scaledWidth, scaledWidth);

                Sink sink = new Sink("Sink", clickPoint, dimension);
                sink.setLocation(clickPoint);
                sink.setDimension(scaledWidth, scaledWidth);

                SinkPainter sinkPainter = new SinkPainter(sink);
                roomView.addElement(sinkPainter);
                roomView.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert valid dimensions!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
