package com.aimsk.pcd.aulas.semana7.TimeServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimeClient {
    private ObjectInputStream in;
    private ObjectOutputStream out;
    private Socket serverSocket;
    public static void main(String[] args) {
        new TimeClient().startClient();
    }


    public void startClient() {
        try {
            doConnections();
            while(true) {
                TimeMessage time = (TimeMessage) in.readObject();
                System.out.println("[CLIENT] Current Time: " + time.getTime());
                out.writeObject(new ReceptionConfirmationMessage("Time " + time.getTime() + " received."));
            }
        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private void doConnections() throws IOException {
        serverSocket = new Socket("localhost", TimeServer.PORT);
        in = new ObjectInputStream(serverSocket.getInputStream());
        out = new ObjectOutputStream(serverSocket.getOutputStream());
    }




}
