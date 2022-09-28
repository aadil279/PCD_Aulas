package com.aimsk.pcd.aulas.semana3.filas;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Fila fila = new Fila();
        Thread[] threads = new Thread[6];
        for(int i = 0; i<threads.length; i++){
            threads[i] = new FilaThread(fila, "Fila " + i);
            threads[i].start();
        }

        for(int i = 0; i < threads.length; i++)
            threads[i].join();

        System.out.println("Fila final: " + fila);
        System.out.println("Tamanho da fila. " + fila.size());

    }
}
