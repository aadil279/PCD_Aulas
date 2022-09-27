package com.aimsk.pcd.aulas.semana3.counters;

import java.util.concurrent.atomic.AtomicInteger;

// Identico ao Contador, exceto utiliza AtomicInteger em vez de int
// Unica diferença esta no metodo increment
public class AtomicCounter {
    private AtomicInteger value;

    public AtomicCounter() {
        value = new AtomicInteger();
    }

    public int getValue() {
        return value.intValue();
    }

    public void incrementValue() {
        value.incrementAndGet();
    }
}
