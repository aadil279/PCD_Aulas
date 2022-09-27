package com.aimsk.pcd.aulas.semana3.counters;

import org.w3c.dom.css.Counter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        AtomicCounter counter = new AtomicCounter();
        Thread[] threads = new Thread[4];

        for(int i = 0; i < threads.length; i++) {
            threads[i] = new CounterThread(counter);
            threads[i].start();
        }

        for(Thread t : threads) {
            t.join();
        }

        System.out.println(counter.getValue());
    }
}
