package raf.draft.dsw.model.repository;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.model.factories.BuildingFactory;
import raf.draft.dsw.model.factories.DraftNodeFactory;
import raf.draft.dsw.model.factories.ProjectFactory;
import raf.draft.dsw.model.factories.RoomFactory;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Building;
import raf.draft.dsw.model.structures.Project;
import raf.draft.dsw.model.structures.ProjectExplorer;
import raf.draft.dsw.model.structures.Room;

public class DraftRepository {
    private DraftNodeFactory projectFactory = new ProjectFactory();
    private DraftNodeFactory roomFactory = new RoomFactory();
    private ChooseDraftNodeFrame frameChooseDraftNode;
    private DraftNodeFactory chosenFactory;

    public DraftNodeFactory getFactory(DraftNode parent) {
        if (parent instanceof ProjectExplorer) {
            return projectFactory;
        } else if (parent instanceof Project) {
            frameChooseDraftNode = new ChooseDraftNodeFrame();
            frameChooseDraftNode.setVisible(true);
            return chosenFactory;
        } else if (parent instanceof Building) {
            return roomFactory;
        } else if (parent instanceof Room) {
            return chosenFactory;
        }
        return null;
    }

    public DraftNodeFactory getProjectFactory() {
        return projectFactory;
    }

    public void setProjectFactory(DraftNodeFactory projectFactory) {
        this.projectFactory = projectFactory;
    }

    public DraftNodeFactory getRoomFactory() {
        return roomFactory;
    }

    public void setRoomFactory(DraftNodeFactory roomFactory) {
        this.roomFactory = roomFactory;
    }

    public ChooseDraftNodeFrame getFrameChooseDraftNode() {
        return frameChooseDraftNode;
    }

    public void setFrameChooseDraftNode(ChooseDraftNodeFrame frameChooseDraftNode) {
        this.frameChooseDraftNode = frameChooseDraftNode;
    }

    public DraftNodeFactory getChosenFactory() {
        return chosenFactory;
    }

    public void setChosenFactory(DraftNodeFactory chosenFactory) {
        this.chosenFactory = chosenFactory;
    }
}
