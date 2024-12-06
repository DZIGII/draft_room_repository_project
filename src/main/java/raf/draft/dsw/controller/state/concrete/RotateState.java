package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;

public class RotateState implements State {

    @Override
    public void log() {
        System.out.println("Rotete state");
    }

}
