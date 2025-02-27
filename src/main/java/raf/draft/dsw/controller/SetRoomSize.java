package raf.draft.dsw.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomDimensionsFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.model.structures.Room;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class SetRoomSize implements MouseListener {

    private Room room;
    private JTextField width;
    private JTextField height;
    private RoomDimensionsFrame roomDimensionsFrame;

    public SetRoomSize(Room room, JTextField width, JTextField height, RoomDimensionsFrame roomDimensionsFrame) {
        this.room = room;
        this.width = width;
        this.height = height;
        this.roomDimensionsFrame = roomDimensionsFrame;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(width.getText() + " " + height.getText());
        if (!width.getText().matches("\\d+") || !height.getText().matches("\\d+")) {
            MainFrame.getInstance().getMessageGenerator().generateMessage("Width and height must contains only digits", "ERROR");
        }
        else {
            room.setWidth(Integer.parseInt(width.getText()));
            room.setHeight(Integer.parseInt(height.getText()));
            RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
            selectedComponent.removeAll();
            selectedComponent.revalidate();
            selectedComponent.repaint();
            width.setText("");
            height.setText("");
            roomDimensionsFrame.dispose();
            MainFrame.getInstance().getMessageGenerator().generateMessage("Succsess set width and height", "INFORMATION");
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
