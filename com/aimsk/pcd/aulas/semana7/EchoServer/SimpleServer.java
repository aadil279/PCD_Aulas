package com.aimsk.pcd.aulas.semana7.EchoServer;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
    public static final int PORTO = 8980;

    private BufferedReader in;
    private PrintWriter out;

    public static void main(String[] args) {
        try {
            new SimpleServer().startServing();
        } catch (IOException e) {
           // System.out.println("erro");
        }
    }

    private void startServing() throws IOException{
        ServerSocket ss = new ServerSocket(PORTO);

        try {
            Socket socket = ss.accept();
            try {   // ligacao aceite
                doConnections(socket);
                serve();
            } finally { // a fechar...
                socket.close();
            }
        } finally {
            ss.close();
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
