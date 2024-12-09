package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;

public class EditState implements State {

    @Override
    public void log() {
        System.out.println("Edit State");
    }

    @Override
    public void printBed() {

    }

}
