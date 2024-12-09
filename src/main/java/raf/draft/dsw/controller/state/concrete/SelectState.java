package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;

public class SelectState implements State {

    @Override
    public void log() {
        System.out.println("Select state");
    }

    @Override
    public void printBed() {

    }

}
