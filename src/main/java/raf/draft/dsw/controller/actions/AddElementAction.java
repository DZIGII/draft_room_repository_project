package raf.draft.dsw.controller.actions;

import raf.draft.dsw.controller.messagegenerator.MessageGenerator;
import raf.draft.dsw.gui.swing.ChoseElementFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.gui.swing.RoomView;
import raf.draft.dsw.model.structures.Room;

import java.awt.event.ActionEvent;

public class AddElementAction extends AbstactRoomAction {

    public AddElementAction() {
        putValue(SMALL_ICON, loadIcon("/images/add-state.png"));
        putValue(NAME, "Add Element");
        putValue(SHORT_DESCRIPTION, "Add Element");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        RoomView selectedComponent = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent();
        Room room = selectedComponent.getRoom();

        if (room.getWidth() != 0 && room.getHeight() != 0) {
            selectedComponent.startAddElemetState();
            ChoseElementFrame cf = new ChoseElementFrame();
            cf.setVisible(true);
        }
        else {
            MainFrame.getInstance().getMessageGenerator().generateMessage("Set room size first", "ERROR");
        }


    }
}
