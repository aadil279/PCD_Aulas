package com.aimsk.pcd.aulas.semana7.EchoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static final int PORTO = 8980;       // TODO Ver como aceitar varios clientes no mesmo porto



    public static void main(String[] args) {
        try {
            new SimpleServer().startServing();
        } catch (IOException e) {
           // System.out.println("erro");
        }
    }

    public void startServing() throws IOException{
        ServerSocket ss = new ServerSocket(PORTO);

        try {
            while(true) {
                wait();
                Socket socket = ss.accept();
                new ServerResponse(socket).start();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            ss.close();
        }
    }



    private class ServerResponse extends Thread {

        private Socket socket;

        private BufferedReader in;
        private PrintWriter out;

        public ServerResponse(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                try {   // ligacao aceite
                    doConnections(socket);
                    serve();
                } finally { // a fechar...
                    socket.close();
                }
            }catch (IOException e) {

            }
        }

        private void doConnections(Socket socket) throws IOException {
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
        }

        private void serve() throws IOException {
            while(true) {
                String str = in.readLine();

                if(str.equals("FIM"))   break;

                System.out.println("Echo: " + str);
                out.println(str + " do Server");
            }
            System.out.println("Terminado");
        }
    }
}
