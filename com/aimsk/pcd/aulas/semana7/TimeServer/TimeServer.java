package com.aimsk.pcd.aulas.semana7.TimeServer;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class TimeServer {
    public static final int PORT = 2424;
    public static final long TIME_CYCLE = 30000;     // Tempo entre cada ciclo de envio de tempo
    public static final int TIMEOUT = 2000;         // Passados dois segundos

    public static void main(String[] args) {
        TimeServer server = new TimeServer();
        try {
            server.startServing();
        }catch(IOException e){
            throw new RuntimeException();
        }
    }

    public void startServing() throws IOException{
        ServerSocket ss = new ServerSocket(PORT);
        System.out.println("Server started...");
        try{
            while(true) {
                Socket clientSocket = ss.accept();
                System.out.println("[CONNECTION] New connection started");
                new ClientSocketHandler(clientSocket).start();
            }
        }finally{
            ss.close();
        }
    }

    /**
     * Private class to handle the server response to each individual client
     * @author Aadil Sidik
     */
    private class ClientSocketHandler extends Thread{
        private final Socket client;
        private ObjectOutputStream out;
        private ObjectInputStream in;
        private boolean stop = false;
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
            client.setSoTimeout(TIMEOUT);
        }

        @Override
        public void run() {

            try {
                while(!stop) {
                    out.writeObject(new TimeMessage(System.currentTimeMillis()));
                    ReceptionConfirmationMessage message = (ReceptionConfirmationMessage) in.readObject();
                    System.out.println("[SERVER] Received message from client " + message.getText());
                    sleep(TIME_CYCLE);
                }

            } catch(SocketTimeoutException e ) {
                System.out.println("Timeout! Fechando Thread...");
                try {
                    client.close();
                    stopThread();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            } catch (IOException | ClassNotFoundException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        public void stopThread() {
            this.stop = true;
        }
    }

}
