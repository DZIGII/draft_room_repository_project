package raf.draft.dsw.gui.swing;

import raf.draft.dsw.controller.actions.ChooseBuildingAction;
import raf.draft.dsw.controller.actions.ChooseRoomAction;
import raf.draft.dsw.core.ApplicationFramework;
import raf.draft.dsw.model.factories.BuildingFactory;
import raf.draft.dsw.model.factories.RoomFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

public class ChooseDraftNodeFrame extends JDialog{
    private JLabel buildingLabel;
    private JLabel roomLabel;

    private ImageIcon buildingIcon;
    private ImageIcon roomIcon;

    private JButton buildingButton;
    private JButton roomButton;


    public ChooseDraftNodeFrame(){
        setModal(true);
        setTitle("Choose Node Type");
        setSize(300, 200);
        setLocationRelativeTo(null);

        JButton buildingButton = new JButton("Building");
        JButton roomButton = new JButton("Room");

        buildingButton.addActionListener(MainFrame.getInstance().getActionManager().getChooseBuildingAction());

        roomButton.addActionListener(MainFrame.getInstance().getActionManager().getChooseRoomAction());

        add(buildingButton);
        add(roomButton);
        setLayout(new FlowLayout());
//        initElements();
//        showElements();
    }

    public void initElements() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(screenWidth / 4, screenHeight / 4);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Choose Draft Room Item");

        buildingIcon = loadIcon("/images/building.png");
        roomIcon = loadIcon("/images/room.png");

        buildingButton = new JButton(buildingIcon);
        roomButton = new JButton(roomIcon);

        buildingButton.addActionListener(MainFrame.getInstance().getActionManager().getChooseBuildingAction());
        roomButton.addActionListener(MainFrame.getInstance().getActionManager().getChooseRoomAction());

    }

    public void showElements() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(1, 2));
        jp.add(buildingButton, BorderLayout.CENTER);
        jp.add(roomButton, BorderLayout.CENTER);
//        jp.add(buildingLabel, BorderLayout.CENTER);
//        jp.add(roomLabel, BorderLayout.CENTER);

        this.add(jp);
        setVisible(true);
    }

    public ImageIcon loadIcon(String path) {
        ImageIcon icon = null;
        URL ImageURL = getClass().getResource(path);
        if(ImageURL != null)
        {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(200, 200, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else
        {
            System.err.println("File not found");
        }
        return icon;
    }
}
