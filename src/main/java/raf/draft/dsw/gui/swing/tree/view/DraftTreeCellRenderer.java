package raf.draft.dsw.gui.swing.tree.view;

import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;

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

        Icon icon = null;
        if (imageURL != null)
            icon = new ImageIcon(imageURL);
        setIcon(icon);

        return this;
    }
}
