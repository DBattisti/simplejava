package com.dbattisti.echoclient;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class EchoClient extends Thread {

    private String host;
    private int port;

    public EchoClient(String host, int port) {
        this.host = host;
        this.port = port;
    }

    @Override
    public void run() {
        System.out.println("Connect to server " + host + " port " + port);

        try (Socket soc = new Socket(host, port); DataOutputStream os = new DataOutputStream(soc.getOutputStream());) {
            os.writeBytes("aksfnalsfbalbljkabsfajkbjabsjfbajksbjkabsjfabskfj");
            os.flush();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

    }

}
