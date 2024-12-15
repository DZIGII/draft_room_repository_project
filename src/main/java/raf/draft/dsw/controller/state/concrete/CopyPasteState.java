package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.gui.swing.painter.*;
import raf.draft.dsw.model.structures.roomElements.*;

import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class CopyPasteState implements State {

    @Override
    public void log() {
        System.out.println("Copy Paste State");
    }

    @Override
    public void paintElement(Point2D clickPoint, RoomView roomView) {

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

    @Override
    public void copy() {
        RoomView roomView = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        List<ElementPainter> copy = new ArrayList<>();
        for (ElementPainter painter : roomView.getPainters()) {
            if (painter.isSelected()) {
                if (painter instanceof BedPainter) {
                    Bed bed = (Bed) ((BedPainter) painter).getBed().clone();
                    BedPainter bedPainter = new BedPainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof BathtubPainter) {
                    Bathtub bed = (Bathtub) ((BathtubPainter) painter).getBathtub().clone();
                    BathtubPainter bedPainter = new BathtubPainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof BoilerPainter) {
                    Boiler boiler = (Boiler) ((BoilerPainter) painter).getBoiler().clone();
                    BoilerPainter boilerPainter = new BoilerPainter(boiler);
                    copy.add(boilerPainter);
                }
                if (painter instanceof ClosetPainter) {
                    Closet bed = (Closet) ((ClosetPainter) painter).getCloset().clone();
                    ClosetPainter bedPainter = new ClosetPainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof DoorPainter) {
                    Door bed = (Door) ((DoorPainter) painter).getDoor().clone();
                    DoorPainter bedPainter = new DoorPainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof SinkPainter) {
                    Sink bed = (Sink) ((SinkPainter) painter).getSink().clone();
                    SinkPainter bedPainter = new SinkPainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof TablePainter) {
                    Table bed = (Table) ((TablePainter) painter).getTable().clone();
                    TablePainter bedPainter = new TablePainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof ToiletPainter) {
                    Toilet bed = (Toilet) ((ToiletPainter) painter).getToilet().clone();
                    ToiletPainter bedPainter = new ToiletPainter(bed);
                    copy.add(bedPainter);
                }
                if (painter instanceof WashingMachinePainter) {
                    WashingMachine bed = (WashingMachine) ((WashingMachinePainter) painter).getMachine().clone();
                    WashingMachinePainter bedPainter = new WashingMachinePainter(bed);
                    copy.add(bedPainter);
                }

            }
        }
        roomView.getPainters().addAll(copy);
        roomView.repaint();
    }


}
