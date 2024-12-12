package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.TablePainter;
import raf.draft.dsw.gui.swing.painter.ToiletPainter;
import raf.draft.dsw.model.structures.roomElements.Table;
import raf.draft.dsw.model.structures.roomElements.Toilet;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddToiletState implements State {

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

                Toilet toilet = new Toilet("Toilet", clickPoint, dimension);
                toilet.setLocation(clickPoint);
                toilet.setDimension(width, height);

                ToiletPainter toiletPainter = new ToiletPainter(toilet);
                roomView.addElement(toiletPainter);
                roomView.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert valid dimensions!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
}
