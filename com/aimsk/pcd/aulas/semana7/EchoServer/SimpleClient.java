package com.aimsk.pcd.aulas.semana7.EchoServer;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

import static java.lang.Thread.sleep;

public class SimpleClient {
    public static final int NUMERO_MENSAGENS = 10;
    private BufferedReader in;
    private PrintWriter out;
    private Socket socket;

    public static void main(String[] args) {

        try {
            new SimpleClient().runClient();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void runClient() throws InterruptedException{
        try {
            connectToServer();
            notifyAll();
            sendMessages();
        } catch (IOException e) {
            //System.out.println("erro");
        } finally { // a fechar
            try {
                socket.close();
            } catch (IOException e) {
                //System.out.println("erro");
            }
        }
    }

    private void connectToServer() throws IOException {
        InetAddress endereco = InetAddress.getByName("192.168.1.1");
        socket = new Socket("localhost", SimpleServer.PORTO);

        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())), true);
    }

    private void sendMessages() throws IOException, InterruptedException{
        for(int i = 0; i < NUMERO_MENSAGENS; i++) {
            out.println("Ola " + i);
            String str = in.readLine();
            System.out.println(str);
            sleep(1000);
        }
        out.println("FIM");
    }
}
