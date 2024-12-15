package raf.draft.dsw.gui.swing;

import com.sun.tools.javac.Main;
import raf.draft.dsw.model.factories.*;
import raf.draft.dsw.model.structures.Prototype;
import raf.draft.dsw.model.structures.Room;
import raf.draft.dsw.model.structures.roomElements.Bed;
import raf.draft.dsw.model.structures.roomElements.Door;
import raf.draft.dsw.model.structures.roomElements.RoomElement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.URL;

public class ChoseElementFrame extends JDialog {

    private ImageIcon door;
    private ImageIcon bed;
    private ImageIcon table;
    private ImageIcon closet;
    private ImageIcon bathTube;
    private ImageIcon washingMachine;
    private ImageIcon boiler;
    private ImageIcon toilet;
    private ImageIcon sink;

    private JButton doorBtn;
    private JButton bedBtn;
    private JButton tableBtn;
    private JButton closetBtn;
    private JButton bathBtn;
    private JButton washingMachineBtn;
    private JButton boilerBtn;
    private JButton toiletBtn;
    private JButton sinkBtn;

    public ChoseElementFrame() {
        setModal(true);
        initElements();
        showElements();
        controller();
    }


    private void initElements() {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;
        setSize(500, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setTitle("Choose Element To Add");

        door = loadIcon("/images/door.png");
        bed = loadIcon("/images/bed.png");
        table = loadIcon("/images/table.png");
        closet = loadIcon("/images/closet.png");
        bathTube = loadIcon("/images/bath.png");
        washingMachine = loadIcon("/images/washing-machine.png");
        boiler = loadIcon("/images/boiler.png");
        toilet = loadIcon("/images/toilet.png");
        sink = loadIcon("/images/sink.png");

        doorBtn = new JButton(door);
        bedBtn = new JButton(bed);
        tableBtn = new JButton(table);
        closetBtn = new JButton(closet);
        bathBtn = new JButton(bathTube);
        washingMachineBtn = new JButton(washingMachine);
        boilerBtn = new JButton(boiler);
        toiletBtn = new JButton(toilet);
        sinkBtn = new JButton(sink);
    }

    private void showElements() {
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2, 5));
        jp.add(doorBtn, BorderLayout.CENTER);
        jp.add(bedBtn, BorderLayout.CENTER);
        jp.add(tableBtn, BorderLayout.CENTER);
        jp.add(closetBtn, BorderLayout.CENTER);
        jp.add(bathBtn, BorderLayout.CENTER);
        jp.add(washingMachineBtn, BorderLayout.CENTER);
        jp.add(boilerBtn, BorderLayout.CENTER);
        jp.add(toiletBtn, BorderLayout.CENTER);
        jp.add(sinkBtn, BorderLayout.CENTER);
        this.add(jp);
    }

    private void controller() {
        RoomView roomView = (RoomView) MainFrame.getInstance().getTabFrame().getSelectedComponent(); // trenutno aktivan tab
        bedBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new BedFactory());
            roomView.startAddBedState();
            this.dispose();
        });
        doorBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new DoorFactory());
            roomView.startAddDoorState();
            this.dispose();
        });
        tableBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new TableFactory());
            roomView.startAddTableState();
            this.dispose();
        });
        closetBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new ClosetFactory());
            roomView.startAddClosetState();
            this.dispose();
        });
        bathBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new BathtabFactory());
            roomView.startAddBathtubState();
            this.dispose();
        });
        washingMachineBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new WashingMachineFactory());
            roomView.startAddWashingMachineState();
            this.dispose();
        });
        boilerBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new BoilerFactory());
            roomView.startAddBoilerState();
            this.dispose();
        });
        toiletBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new ToiletFactory());
            roomView.startAddToiletState();
            this.dispose();
        });
        sinkBtn.addActionListener(e -> {
            //MainFrame.getInstance().getDraftTree().getRepository().setChosenFactory(new SinkFactory());
            roomView.startAddSinkState();
            this.dispose();
        });


    }

    public ImageIcon loadIcon(String path) {
        ImageIcon icon = null;
        URL ImageURL = getClass().getResource(path);
        if(ImageURL != null)
        {
            Image img = new ImageIcon(ImageURL).getImage();
            Image newImg = img.getScaledInstance(64, 64, Image.SCALE_DEFAULT);
            icon = new ImageIcon(newImg);
        }
        else
        {
            System.err.println("File not found");
        }
        return icon;
    }

}
