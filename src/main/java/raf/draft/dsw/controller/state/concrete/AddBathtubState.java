package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BathtubPainter;
import raf.draft.dsw.gui.swing.painter.DoorPainter;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.model.structures.roomElements.Bathtub;
import raf.draft.dsw.model.structures.roomElements.Door;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddBathtubState implements State {

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

//                if () {
//
//                }

                System.out.println(clickPoint.getX());
                System.out.println(clickPoint.getY());

                if(adjustedRoomWidth<scaledWidth || adjustedRoomHeight<scaledHeight || clickPoint.getX() + scaledWidth > roomView.getPoint().getX() + adjustedRoomWidth || clickPoint.getY() + scaledHeight > roomView.getPoint().getY() + adjustedRoomHeight || clickPoint.getX() < roomView.getPoint().getX() || clickPoint.getY() < roomView.getPoint().getY()) {
                    JOptionPane.showMessageDialog(null, "Element exceeds room boundaries!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                Dimension2D dimension = new Dimension();
                dimension.setSize(scaledWidth, scaledHeight);

                Bathtub bathtub = new Bathtub("Bathtub", clickPoint, dimension);
                bathtub.setLocation(clickPoint);
                bathtub.setDimension(scaledWidth, scaledHeight);

                BathtubPainter bathtubPainter = new BathtubPainter(bathtub);
                roomView.addElement(bathtubPainter);
                roomView.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert valid dimensions!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public DraftTreeItem findTreeItemForRoom(DraftTreeItem root, Room room) {
        // Ako je trenutni čvor traženi `Room`
        if (root.getDraftNode() instanceof Room && root.getDraftNode().equals(room)) {
            return root;
        }

        // Pretraga kroz decu
        for (int i = 0; i < root.getChildCount(); i++) {
            DraftTreeItem child = (DraftTreeItem) root.getChildAt(i);
            DraftTreeItem found = findTreeItemForRoom(child, room);
            if (found != null) {
                return found;
            }
        }

        return null; // Ako nije pronađen
    }
}
