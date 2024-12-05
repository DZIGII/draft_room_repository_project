package raf.draft.dsw.controller.actions;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomDimensionsFrame;
import raf.draft.dsw.model.structures.Room;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AddDimensionAction implements MouseListener {

    private Room room;

    public AddDimensionAction(Room room) {
        this.room = room;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (room.getHeight() == 0 || room.getWidth() == 0) {
            RoomDimensionsFrame frame = new RoomDimensionsFrame(room);
        }
        else {
            // Room ima dimenzije
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
