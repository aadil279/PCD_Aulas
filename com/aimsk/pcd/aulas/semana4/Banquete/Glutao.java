package com.aimsk.pcd.aulas.semana4.Banquete;

public class Glutao extends Thread{
    @Override
    public void run() {
        while(Mesa.getMesa().getTotalJavalis() < Main.NUMERO_TOTAL_A_CONSUMIR || !Mesa.getMesa().isEmpty()) {

            try {
                Mesa.getMesa().consume();
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        }

        System.out.println(getNome() + " terminado");
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
