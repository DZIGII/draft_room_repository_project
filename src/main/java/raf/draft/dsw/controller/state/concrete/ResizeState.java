package raf.draft.dsw.controller.state.concrete;

import raf.draft.dsw.controller.state.State;

public class ResizeState implements State {

    @Override
    public void log() {
        System.out.println("Resize State");
    }

}
