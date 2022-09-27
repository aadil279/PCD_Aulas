package com.aimsk.pcd.aulas.semana3.counters;

public class Contador {
    private int value;
    //private static Contador contador;

    public Contador() {
        value = 0;
    }

    //NESTE EXERCICIO NAO FAZ SENTIDO MAS PODE SER UTIL
    /*public static Contador getInstance() {
        if(contador == null)
            contador = new Contador();
        return contador;
    }*/

    public int getValue() {
        return value;
    }

    public synchronized void incrementValue() {
        value++;
    }
}
