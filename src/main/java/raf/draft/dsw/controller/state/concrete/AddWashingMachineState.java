package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.TablePainter;
import raf.draft.dsw.gui.swing.painter.WashingMachinePainter;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.model.structures.roomElements.Table;
import raf.draft.dsw.model.structures.roomElements.WashingMachine;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Dimension2D;
import java.awt.geom.Point2D;

public class AddWashingMachineState implements State {
    private static int brojac = 1;

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

                WashingMachine washingMachine = new WashingMachine("WashingMachine " + brojac++, clickPoint, dimension);
                DraftTreeItem parentItem = findTreeItemForRoom((DraftTreeItem) MainFrame.getInstance().getDraftTree().getTreeView().getModel().getRoot(), roomView.getRoom());
                parentItem.add(new DraftTreeItem(washingMachine));
                roomView.getRoom().addChild(washingMachine);
                MainFrame.getInstance().getDraftTree().getTreeView().expandPath(MainFrame.getInstance().getDraftTree().getTreeView().getSelectionPath());
                SwingUtilities.updateComponentTreeUI(MainFrame.getInstance().getDraftTree().getTreeView());
                roomView.getRoom().addChild(washingMachine);

                washingMachine.setLocation(clickPoint);
                washingMachine.setDimension(scaledWidth, scaledWidth);

                WashingMachinePainter washingMachinePainter = new WashingMachinePainter(washingMachine);
                roomView.addElement(washingMachinePainter);
                roomView.repaint();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please insert valid dimensions!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    public DraftTreeItem findTreeItemForRoom(DraftTreeItem root, Room room) {
        if (root.getDraftNode() instanceof Room && root.getDraftNode().equals(room)) {
            return root;
        }

        for (int i = 0; i < root.getChildCount(); i++) {
            DraftTreeItem child = (DraftTreeItem) root.getChildAt(i);
            DraftTreeItem found = findTreeItemForRoom(child, room);
            if (found != null) {
                return found;
            }
        }

        return null;
    }
}
