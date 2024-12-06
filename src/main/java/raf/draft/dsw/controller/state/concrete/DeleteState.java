package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;


public class DeleteState implements State {

    @Override
    public void log() {
        System.out.println("Delete State");
    }

}
