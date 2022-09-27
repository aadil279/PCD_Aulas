package com.aimsk.pcd.aulas.semana2.HorseRace;

import javax.swing.*;

public class Horse extends Thread{
    private final JTextField textField;

    public Horse(JTextField textField) {
        this.textField = textField;
    }

    public JTextField getTextField() {
        return this.textField;
    }

    @Override
    public void run() {
        try {
            while(Integer.valueOf(textField.getText()) > 0){

                sleep((int) (Math.random() * 100));
                int newValue = Integer.valueOf(textField.getText()) - 1;
                textField.setText(String.valueOf(newValue));
            }
            GameFrame.getFrame().endRace(this);

        } catch (InterruptedException e){
            System.out.println(currentThread() + " lost");
        }
    }
}
