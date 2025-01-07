package raf.draft.dsw.model.structures;

import com.fasterxml.jackson.annotation.JsonIgnore;
import raf.draft.dsw.controller.observer.IPublisher;
import raf.draft.dsw.controller.observer.ISubscriber;
import raf.draft.dsw.model.nodes.DraftNode;
import raf.draft.dsw.model.nodes.DraftNodeComposite;

import java.util.ArrayList;
import java.util.List;

public class Project extends DraftNodeComposite implements IPublisher {
    private String projectName;
    private String creatorName;
    private String pathToProjectResources;
    private boolean changed = false;

    @JsonIgnore
    private List<ISubscriber> subscribers = new ArrayList<>();

    public Project(String name, DraftNode parent) {
        super(name, parent);
    }

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
        this.changed = true;
        this.projectName = projectName;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.changed = true;
        this.creatorName = creatorName;
    }

    public String getPathToProjectResources() {
        return pathToProjectResources;
    }

    public void setPathToProjectResources(String pathToProjectResources) {
        this.pathToProjectResources = pathToProjectResources;
    }

    @Override
    public String toString() {
        return "Project{" +
                "projectName='" + projectName + '\'' +
                ", creatorName='" + creatorName + '\'' +
                ", pathToProjectResources='" + pathToProjectResources + '\'' +
                '}';
    }

    @Override
    public void notifySubscribers(Object notification) {
        for(ISubscriber s : subscribers) {
            s.recive(notification);
        }
    }

    @Override
    public void subscribe(ISubscriber logger) {
        if (!subscribers.contains(logger)) {
            subscribers.add(logger);
        }
    }

    @Override
    public void unsubscribe(ISubscriber logger) {
        subscribers.remove(logger);
    }

    @Override
    public void notifyDeleted() {
        this.changed = true;
        for (ISubscriber s : subscribers) {
            s.nodeDeleted();
        }
    }

    @Override
    public void notifyAdded() {
        this.changed = true;
        for (ISubscriber s : subscribers) {
            s.nodeAdded();
        }
    }

    public void select() {
        String info =  "Project name: " + projectName + " / Author: " + creatorName;
        notifySubscribers(info);
    }

    public boolean isChanged() {
        return changed;
    }

    public void setChanged(boolean changed) {
        this.changed = changed;
    }

}
