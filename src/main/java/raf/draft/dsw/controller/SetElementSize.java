package raf.draft.dsw.controller;

import raf.draft.dsw.gui.swing.ElementDimensionFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Dimension2D;

public class SetElementSize implements MouseListener {

    private RoomElement roomElement;
    private JTextField widthField;
    private JTextField heightField;
    private ElementDimensionFrame elementDimensionFrame;

    public SetElementSize(RoomElement roomElement, JTextField widthField, JTextField heightField, ElementDimensionFrame elementDimensionFrame) {
        this.roomElement = roomElement;
        this.widthField = widthField;
        this.heightField = heightField;
        this.elementDimensionFrame = elementDimensionFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (!widthField.getText().matches("\\d+") || !heightField.getText().matches("\\d+")) {
            MainFrame.getInstance().getMessageGenerator().generateMessage("Lenght and width must contains only digits", "ERROR");
        }
        else {
            roomElement.setDimension(Integer.parseInt(widthField.getText()), Integer.parseInt(heightField.getText()));

            widthField.setText("");
            heightField.setText("");
            elementDimensionFrame.dispose();
            MainFrame.getInstance().getMessageGenerator().generateMessage("Succsess set width and length", "INFORMATION");
        }
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
}
