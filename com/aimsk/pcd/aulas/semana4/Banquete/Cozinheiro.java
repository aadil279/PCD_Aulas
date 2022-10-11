package com.aimsk.pcd.aulas.semana4.Banquete;

public class Cozinheiro extends Thread{

    @Override
    public void run() {
        while(Mesa.getMesa().getTotalJavalis() < Main.NUMERO_TOTAL_A_CONSUMIR){
            try {
                Mesa.getMesa().add(new Javali(this, Mesa.getMesa().incrementJavalis()));     // Adiciona a mesa um javali associado ao cozinheiro atual, com o numero do javali na mesa
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(getNome() + " terminado");
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
