package com.aimsk.pcd.aulas.semana4.Banquete;

import java.util.PriorityQueue;

public class Mesa {
    private static final int NUMERO_DE_JAVALIS = 10;

    private static Mesa estaMesa;
    private PriorityQueue<Javali> mesa;

    private Mesa() {
        mesa = new PriorityQueue<>();
    }

    public static Mesa getMesa() {
        if(estaMesa == null)
            estaMesa = new Mesa();
        return estaMesa;
    }

    public synchronized void add(Javali j) throws InterruptedException {
        while(mesa.size() == NUMERO_DE_JAVALIS)
            wait();

        mesa.add(j);
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while(mesa.size() == 0)
            wait();

        mesa.poll();
        notifyAll();
    }
}
