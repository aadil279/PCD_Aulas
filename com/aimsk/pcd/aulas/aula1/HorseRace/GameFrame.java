package com.aimsk.pcd.aulas.aula1.HorseRace;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowStateListener;
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
        frame.pack();
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
        frame.add(startRace);

    }

    private void startRace() {
        for(Horse h : horses)
            h.start();
    }

    public void endRace() {
        for(Horse h : horses)
            h.interrupt();
    }
}