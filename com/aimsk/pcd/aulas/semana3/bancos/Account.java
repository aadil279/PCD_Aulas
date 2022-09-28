package com.aimsk.pcd.aulas.semana3.bancos;

public class Account {
    private int balance = 0;

    public void deposit(double amount) {
        int finalBalance = (int) Math.round(amount + (double) balance);
        balance = finalBalance;
    }

    public int getBalance() {
        return balance;
    }
}
