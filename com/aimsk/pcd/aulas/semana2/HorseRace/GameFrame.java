package com.aimsk.pcd.aulas.semana2.HorseRace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class GameFrame {
    private JFrame frame;
    private static GameFrame gameFrame;

    public static final int NUMBER_OF_HORSES = 3;
    public static final int RACE_LENGTH = 30;
    private ArrayList<Horse> horses = new ArrayList<Horse>();

    private GameFrame() {
        frame = new JFrame("Horse Race");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        createElements();
        addFrameContent();
        //frame.pack();
    }

    public static GameFrame getFrame() {
        if(gameFrame == null)
            gameFrame = new GameFrame();
        return gameFrame;
    }

    public void open() {
        frame.setVisible(true);
    }
    private void createElements() {
        for (int i = 0; i < NUMBER_OF_HORSES; i++) {
            Horse newHorse = new Horse(new JTextField(String.valueOf(RACE_LENGTH)));
            horses.add(newHorse);
        }
    }

    private void addFrameContent() {
        frame.setLayout(new GridLayout(4,2));
        frame.setSize(new Dimension(350,350));

        for(int i = 0; i < horses.size(); i++){
            JLabel label = new JLabel("Horse " + (i+1));
            JTextField textField = horses.get(i).getTextField();

            frame.add(label);
            frame.add(textField);

        }

        JButton startRace = new JButton("Start");
        startRace.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startRace();
            }
        });
        frame.add(startRace, Component.BOTTOM_ALIGNMENT);

    }

    private void startRace() {
        for(Horse h : horses) {
            h.getTextField().setText(String.valueOf(RACE_LENGTH));
            h.start();
        }
    }

    public void endRace(Horse winner) {
        for(Horse h : horses)       h.interrupt();
        JLabel winnerMessage = new JLabel("Cavalo " + (horses.indexOf(winner) + 1) + " foi o vencedor!");
        frame.add(winnerMessage);

        SwingUtilities.updateComponentTreeUI(frame);
    }

}
