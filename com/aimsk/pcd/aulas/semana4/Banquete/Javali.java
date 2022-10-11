package com.aimsk.pcd.aulas.semana4.Banquete;

public class Javali {
    private final Cozinheiro cozinheiro;
    private final int numero;

    public Javali(Cozinheiro cozinheiro, int numero) {
        this.cozinheiro = cozinheiro;
        this.numero = numero;
    }

    @Override
    public String toString() {
        return "Javali " + numero + " feito por " + cozinheiro;
    }
}
