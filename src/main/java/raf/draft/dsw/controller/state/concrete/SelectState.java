package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.BedPainter;
import raf.draft.dsw.gui.swing.painter.ElementPainter;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.List;

public class SelectState implements State {

    private Point start = null;
    private Point end = null;

    @Override
    public void log() {
        System.out.println("Select state");
    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {

    }

    @Override
    public void mousePressed(MouseEvent e, RoomView roomView) {
        start = e.getPoint();
        end = null;
    }

    @Override
    public void mouseDragged(MouseEvent e, RoomView roomView) {
        end = e.getPoint();
        roomView.repaint();
    }

    @Override
    public void mouseRelease(MouseEvent e, RoomView roomView) {
        if (start != null && end != null) {
            Rectangle selectionRect = createSelectionRectangle(start, end);
            selectElementsInRectangle(selectionRect, roomView.getPainters());
        }
        start = null;
        end = null;
        roomView.repaint();
    }

    private Rectangle createSelectionRectangle(Point start, Point end) {
        int x = Math.min(start.x, end.x);
        int y = Math.min(start.y, end.y);
        int width = Math.abs(start.x - end.x);
        int height = Math.abs(start.y - end.y);
        return new Rectangle(x, y, width, height);
    }

    private void selectElementsInRectangle(Rectangle selectionRect, List<ElementPainter> painters) {
        for (ElementPainter painter : painters) {

            RoomElement element = painter.getElement();

            if (selectionRect.intersects(painter.getBound(element))) {
                painter.setSelected(element, true);
            } else {
                painter.setSelected(element, false);
            }
        }
    }

    public void unselect(RoomView roomView) {
        for (ElementPainter painter : roomView.getPainters()) {
            painter.resetSelected();
        }
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e, RoomView roomView) {

    }

    @Override
    public void copy() {

    }

    public void selectElements() {

    }

    public Point getStart() {
        return start;
    }

    public Point getEnd() {
        return end;
    }
}
