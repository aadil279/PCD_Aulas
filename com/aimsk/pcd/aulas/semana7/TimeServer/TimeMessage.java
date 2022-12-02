package com.aimsk.pcd.aulas.semana7.TimeServer;

import java.io.Serializable;

public class TimeMessage implements Serializable {
    private final long time;

    public TimeMessage(long time) {
        this.time = time;
    }

    public long getTime() {
        return time;
    }
}
