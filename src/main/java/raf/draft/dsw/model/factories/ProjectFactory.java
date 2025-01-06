package raf.draft.dsw.model.factories;

import raf.draft.dsw.gui.swing.ChooseDraftNodeFrame;
import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.structures.Project;

public class ProjectFactory implements DraftNodeFactory{
    public static int brojac = 0;

    @Override
    public DraftNode createNode(DraftNode parent) {
        brojac++;
        Project project = new Project("Project " + brojac, parent);
        MainFrame.getInstance().getProjectController().setCurrentProject(project);
        project.setChanged(true);
        return project;
    }
}
