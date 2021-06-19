package com.dbattisti.echoserver;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoServer extends Thread {

    @Override
    public void run() {
        System.out.println("Start echo server");
        try (ServerSocket serverSocket = new ServerSocket(5000)) {
            while (true)
                new EchoServerClient(serverSocket.accept()).start();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

}
