package raf.draft.dsw.core;

import raf.draft.dsw.gui.swing.MainFrame;
import raf.draft.dsw.model.repository.DraftRoomRepository;

public class ApplicationFramework {
    //buduca polja za model celog projekta
    private static ApplicationFramework instance;

    protected DraftRoomRepository draftRoomRepository;

    private ApplicationFramework(){
        initialize();
    }

    public static ApplicationFramework getInstance(){
        if(instance == null){
            instance = new ApplicationFramework();
        }
        return instance;
    }

    public void initialize(){
        MainFrame mainFrame = MainFrame.getInstance();
        mainFrame.setVisible(true);
    }
}
