package com.aimsk.pcd.aulas.aula1;

public class NameThread extends Thread {
    private final int identifier;
    public static final int NUMBER_TO_REPEAT = 10;

    public NameThread(int identifier) {
        this.identifier = identifier;
    }

    @Override
    public void run() {
        for(int i = 0;i < NUMBER_TO_REPEAT; i++) {
            System.out.println("Sou o thread " + identifier + " [" + i + "]");

            int timeToSleep = 1000;
            if(Math.random() > 0.5)     timeToSleep = 2000;

            try {
                sleep(timeToSleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static void main(String[] args) {
        NameThread thread1 = new NameThread(1);
        NameThread thread2 = new NameThread(2);

        thread1.start();
        thread2.start();
    }
}
