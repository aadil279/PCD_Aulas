package com.aimsk.pcd.aulas.semana7.TimeServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class TimeServer {
    public static final int PORT = 2424;

    public static void main(String[] args) {
        //TODO Server main
    }


    /**
     * Private class to handle the server response to each individual client
     * @author Aadil Sidik
     */
    private class ClientSocketHandler extends Thread{
        private final Socket client;
        private ObjectOutputStream out;
        private ObjectInputStream in;
        /**
         *
         * @param client The socket connected to the client
         */
        public ClientSocketHandler(Socket client) {
            this.client = client;

            try {
                makeConnections();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        /**
         * Function that associates an input and an output to the Threads client
         */
        private void makeConnections() throws IOException {
            out = new ObjectOutputStream(client.getOutputStream());
            in = new ObjectInputStream(client.getInputStream());
        }

        @Override
        public void run() {
            //TODO ClientSocketHandler run method
        }
    }




}
