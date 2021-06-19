package com.dbattisti.echoserver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoServerClient extends Thread {

    private Socket socket;

    public EchoServerClient(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("New client is connected");
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));) {

            String inputLine;

            while ((inputLine = in.readLine()) != null) {
                System.out.println("Server: " + inputLine);

                if (inputLine.equals("?"))
                    inputLine = "\"Bye.\" ends Client, " + "\"End Server.\" ends Server";

                out.println(inputLine);

                if (inputLine.equals("Bye."))
                    break;
            }
            socket.close();

        } catch (IOException e) {
            System.err.println("Problem with Communication Server");
            System.exit(1);
        }
    }

}
