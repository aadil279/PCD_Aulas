package com.aimsk.pcd.aulas.semana3.filas;

public class FilaThread extends Thread{
    private Fila fila;
    private final String name;

    public FilaThread(Fila fila, String name) {
        this.fila = fila;
        this.name = name;
    }

    @Override
    public void run() {
        for(int i = 0; i<1000; i++) {
            fila.offer(i);
        }

        for(int i = 0; i <100; i++)
            fila.poll();

        System.out.println(name + " done: " + fila);
    }
}
