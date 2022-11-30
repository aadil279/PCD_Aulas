package com.aimsk.pcd.aulas.semana7.EchoServer;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
       // SimpleServer server = new SimpleServer();
        //server.startServing();

        for(int i = 0; i < 3; i++){
            SimpleClient client = new SimpleClient();
            client.runClient();
        }
    }
}
