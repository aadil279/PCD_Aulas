package com.aimsk.pcd.aulas.semana3.filas;

public class Fila {
    private int[] queue;
    private int head;
    private int tail;
    private static final int MAXIMUM_SIZE = 1000;

    public Fila() {
        queue = new int[MAXIMUM_SIZE];
        tail = -1;  // -1 porque nao tem nenhum elemento inicialmente
        head = 0;  // 0 porque nao tem nenhum elemento inicialmente
    }

    public boolean empty() {
        return tail == -1;
    }

    public int peek() {
        if(empty())
            throw new IllegalStateException();
        return queue[head];
    }

    public int poll() {
        if(empty())
            throw new IllegalStateException();

        int value = queue[head];
        int lastValue = queue[tail];
        // Shift dos valores para o inicio do array
        for(int i = 0; i < tail-1; i++) {
            queue[i] = queue[i+1];
        }
        tail--;
        queue[tail] = lastValue;

        return value;
    }

    public void offer(int item) {
        tail++;
        if(tail >= queue.length)
            throw new IllegalStateException();

        queue[tail] = item;
    }

    public int size() {
        return tail - head + 1;
    }

    @Override
    public String toString() {
        String result = "[";
        for(int i = head; i <= tail; i++)
            result = result + queue[i] + ", ";

        result = result + "]";
        return result;
    }

}
