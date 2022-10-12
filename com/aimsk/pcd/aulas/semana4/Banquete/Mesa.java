package com.aimsk.pcd.aulas.semana4.Banquete;

import java.util.LinkedList;

//TODO adicionar variavel para a contagem total dos javalis, se chegou ao Limite total, cancelar todos os threads
public class Mesa {
    private static final int NUMERO_DE_JAVALIS = 10;

    private static Mesa estaMesa;
    private LinkedList<Javali> mesa;
    private int totalJavalis = 0;
    private int totalJavalisConsumidos = 0;

    private Mesa() {
        mesa = new LinkedList<>();
    }

    public static synchronized Mesa getMesa() {
        if(estaMesa == null)
            estaMesa = new Mesa();
        return estaMesa;
    }

    public synchronized void add(Javali j) throws InterruptedException {
        while(mesa.size() >= NUMERO_DE_JAVALIS) {
            System.out.println("Mesa cheia, aguardando que javalis sejam retirados...");
            wait();
        }
        mesa.offer(j);
        totalJavalis++;
        System.out.println("[ADD]       " + j + " foi adicionado a mesa.");
        notifyAll();
    }

    public synchronized void consume() throws InterruptedException {
        while(mesa.size() == 0)
            wait();

        Javali retirado = mesa.poll();
        totalJavalisConsumidos++;
        System.out.println("[CONSUME]   " + retirado + " foi retirado da mesa");
        notifyAll();
    }

    public synchronized boolean isEmpty() {
        return mesa.isEmpty();
    }

    public synchronized int getTotalJavalis() {
        return totalJavalis;
    }

    public synchronized int getTotalJavalisConsumidos() {
        return totalJavalisConsumidos;
    }
}
