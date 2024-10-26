package raf.draft.dsw.model.structures;

import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import java.util.ArrayList;

public class Project extends DraftNodeComposite {
    private String projectName;
    private String creatorName;
    private String pathToProjectResources;

    public Project(String name, String projectName, String creatorName, String pathToProjectResources) {
        super(name);
        this.projectName = projectName;
        this.creatorName = creatorName;
        this.pathToProjectResources = pathToProjectResources;
    }

    public Project(String name, ArrayList<DraftNode> children, String projectName, String creatorName, String pathToProjectResources) {
        super(name, children);
        this.projectName = projectName;
        this.creatorName = creatorName;
        this.pathToProjectResources = pathToProjectResources;
    }

    public Project(String name, DraftNode parent, ArrayList<DraftNode> children, String projectName, String creatorName, String pathToProjectResources) {
        super(name, parent, children);
        this.projectName = projectName;
        this.creatorName = creatorName;
        this.pathToProjectResources = pathToProjectResources;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public String getPathToProjectResources() {
        return pathToProjectResources;
    }

    public void setPathToProjectResources(String pathToProjectResources) {
        this.pathToProjectResources = pathToProjectResources;
    }
}
