package raf.draft.dsw.gui.swing.tree.controller;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.tree.model.DraftTreeItem;

import javax.swing.*;
import javax.swing.tree.DefaultTreeCellEditor;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.TreeCellEditor;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.EventObject;

public class DraftTreeCellEditor extends DefaultTreeCellEditor implements ActionListener {
    private Object clickedOn = null;
    private JTextField edit = null;

    public DraftTreeCellEditor(JTree tree, DefaultTreeCellRenderer renderer) {
        super(tree, renderer);
    }

    public Component getTreeCellEditorComponent(JTree tree, Object value, boolean selected, boolean expanded, boolean leaf, int row) {
        //super.getTreeCellEditorComponent(arg0,arg1,arg2,arg3,arg4,arg5);
        clickedOn = value;
        edit=new JTextField(clickedOn.toString());
        edit.addActionListener(this);
        return edit;
    }

    public boolean isCellEditable(EventObject e) {
        if(e instanceof MouseEvent) {
            if(((MouseEvent) e).getClickCount() == 3)
            {
                return true;
            }
        }
        return false;
    }

    public void actionPerformed(ActionEvent e) {
        if(!(clickedOn instanceof DraftTreeItem))
        {
            return;
        }

        ((DraftTreeItem) clickedOn).setName((e.getActionCommand()));
    }
}
