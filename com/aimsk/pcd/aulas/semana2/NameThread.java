package com.aimsk.pcd.aulas.semana2;

public class NameThread extends Thread {
    private final int identifier;
    public static final int NUMBER_TO_REPEAT = 10;

    public NameThread(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < NUMBER_TO_REPEAT; i++) {
                System.out.println("Sou o thread " + identifier + " [" + i + "]");

                int timeToSleep = 1000;
                if (Math.random() > 0.5) timeToSleep = 5000;

                sleep(timeToSleep);
            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + identifier + " interrompido!");
        }
    }

    public static void main(String[] args) throws InterruptedException {
        NameThread thread1 = new NameThread(1);
        NameThread thread2 = new NameThread(2);

        thread1.start();
        thread2.start();

        Thread.sleep(12000);
        thread1.interrupt();
        thread2.interrupt();

        System.out.println("Terminado");
    }
}
