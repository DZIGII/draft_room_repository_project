package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;

public class MoveState implements State {

    @Override
    public void log() {
        System.out.println("Move State");
    }

    @Override
    public void printBed() {

    }

}
