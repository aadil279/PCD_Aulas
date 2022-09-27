package com.aimsk.pcd.aulas.semana3.filas;

public class Fila {
    private int[] queue;
    private int head;
    private int tail;

    public Fila() {
        int[] queue = new int[1000];
        tail = -1;  // -1 porque nao tem nenhum elemento inicialmente
        head = -1;  // -1 porque nao tem nenhum elemento inicialmente
    }

    public boolean empty() {
        return tail == -1;
    }

    public int peek() {
        if(!empty())
            throw new IllegalStateException();
        return queue[head];
    }

    public int poll() {
        return 0;   //TODO acabar isto
    }
}
