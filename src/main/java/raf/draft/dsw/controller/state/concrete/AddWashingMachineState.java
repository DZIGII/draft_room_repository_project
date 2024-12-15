package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.TablePainter;
import raf.draft.dsw.gui.swing.painter.WashingMachinePainter;
import raf.draft.dsw.model.structures.roomElements.Table;
import raf.draft.dsw.model.structures.roomElements.WashingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddWashingMachineState implements State {
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

                Dimension2D dimension = new Dimension();
                dimension.setSize(width, width);

                WashingMachine washingMachine = new WashingMachine("WashingMachine", clickPoint, dimension);
                washingMachine.setLocation(clickPoint);
                washingMachine.setDimension(width, width);

                WashingMachinePainter washingMachinePainter = new WashingMachinePainter(washingMachine);
                roomView.addElement(washingMachinePainter);
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
}
