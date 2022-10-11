package com.aimsk.pcd.aulas.semana4.Banquete;

public class Glutao extends Thread{
    @Override
    public void run() {
        for(int i = 0; i < Main.NUMERO_CONSUMIDO; i++) {

            try {
                Mesa.getMesa().consume();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }
    }

    private final String nome;

    public Glutao(String name) {
        this.nome = name;
    }

    public String getNome() {
        return nome;
    }

    @Override
    public String toString() {
        return getNome();
    }
}
