package raf.draft.dsw.controller;

import raf.draft.dsw.model.Serializer;
import raf.draft.dsw.model.structures.Project;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class ProjectController {
    private Project currentProject;
    private String currentFilePath;

    public void saveProject() {
        if (!currentProject.isChanged()) {
            JOptionPane.showMessageDialog(null, "No changes to save.");
            return;
        }
        if (currentFilePath == null) {
            saveAsProject();
        } else {
            try {
                Serializer.saveToFile(currentFilePath, currentProject);
                currentProject.setChanged(false);
            } catch (IOException e) {
                System.out.println(e);
                //JOptionPane.showMessageDialog(null, "Error saving file: " + e.getMessage());
            }
        }
    }

    public void saveAsProject() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showSaveDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            currentFilePath = file.getAbsolutePath();
            saveProject();
        }
    }

    public void openProject() {
        JFileChooser fileChooser = new JFileChooser();
        int option = fileChooser.showOpenDialog(null);
        if (option == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                currentProject = Serializer.loadFromFile(file.getAbsolutePath(), Project.class);
                currentFilePath = file.getAbsolutePath();
                currentProject.setChanged(false);
                JOptionPane.showMessageDialog(null, "Project successfully loaded!");
            } catch (IOException e) {
                JOptionPane.showMessageDialog(null, "Error loading file: " + e.getMessage());
            }
        }
    }

    public Project getCurrentProject() {
        return currentProject;
    }

    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public void setCurrentFilePath(String currentFilePath) {
        this.currentFilePath = currentFilePath;
    }
}
