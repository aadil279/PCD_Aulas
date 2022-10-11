package com.aimsk.pcd.aulas.semana4.Banquete;

public class Main {
    protected static final int NUMERO_TOTAL_A_CONSUMIR = 15;

    public static void main(String[] args) {
        //TODO Terminar a main do Banquete
        Cozinheiro[] cozinheiros = new Cozinheiro[3];
        Glutao[] glutoes = new Glutao[3];

        for(int i = 0; i < cozinheiros.length; i++)
            cozinheiros[i] = new Cozinheiro("Cozinheiro " + (i+1) );

        for(int i = 0; i < glutoes.length; i++)
            glutoes[i] = new Glutao("Glutao " + (i+1));

        for(int i = 0; i < cozinheiros.length; i++)
            cozinheiros[i].start();

        for(int i = 0; i < glutoes.length; i++)
            glutoes[i].start();
    }
}
