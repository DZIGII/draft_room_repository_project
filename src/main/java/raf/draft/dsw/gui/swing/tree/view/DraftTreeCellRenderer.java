package raf.draft.dsw.gui.swing.tree.view;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.model.structures.roomElements.*;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;
import java.net.URL;

public class DraftTreeCellRenderer extends DefaultTreeCellRenderer {
    public Component getTreeCellRendererComponent(JTree tree, Object value, boolean isSelected, boolean expanded, boolean leaf, int row, boolean hasFocus) {
        super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
        URL imageURL = null;

        if (((DraftTreeItem)value).getDraftNode() instanceof ProjectExplorer) {
            imageURL = getClass().getResource("/images/tdiagram.gif");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Project) {
            imageURL = getClass().getResource("/images/tproject.gif");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Building) {
            imageURL = getClass().getResource("/images/buildingTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Room) {
            imageURL = getClass().getResource("/images/roomTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Boiler) {
            imageURL = getClass().getResource("/images/boilerTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Bathtub) {
            imageURL = getClass().getResource("/images/bathTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Bed) {
            imageURL = getClass().getResource("/images/bedTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Closet) {
            imageURL = getClass().getResource("/images/closetTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Door) {
            imageURL = getClass().getResource("/images/doorTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Sink) {
            imageURL = getClass().getResource("/images/sinkTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Table) {
            imageURL = getClass().getResource("/images/tableTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof Toilet) {
            imageURL = getClass().getResource("/images/toiletTreeIcon.png");
        }
        else if (((DraftTreeItem)value).getDraftNode() instanceof WashingMachine) {
            imageURL = getClass().getResource("/images/washing-machineTreeIcon.png");
        }

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);

        return this;
    }
}
