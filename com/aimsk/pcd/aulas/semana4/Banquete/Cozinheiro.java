package com.aimsk.pcd.aulas.semana4.Banquete;

public class Cozinheiro extends Thread{

    @Override
    public void run() {
        for(int i = 0; i < Main.NUMERO_CONSUMIDO; i++) {
            try {
                Mesa.getMesa().add(new Javali(this, i));
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private String nome;
    public Cozinheiro(String name) {
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
