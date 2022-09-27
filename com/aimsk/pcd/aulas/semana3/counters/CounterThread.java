package com.aimsk.pcd.aulas.semana3.counters;

public class CounterThread extends Thread{
    public static int NUMBER_OF_TIMES_TO_REPEAT = 1000;

    private AtomicCounter counter;

    public CounterThread(AtomicCounter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {
        for(int i = 0; i < NUMBER_OF_TIMES_TO_REPEAT; i++)
            counter.incrementValue();
    }
}
