package com.aimsk.pcd.aulas.semana7.TimeServer;

import java.io.Serializable;

public class ReceptionConfirmationMessage implements Serializable {
    private final String text;


    public ReceptionConfirmationMessage(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}
