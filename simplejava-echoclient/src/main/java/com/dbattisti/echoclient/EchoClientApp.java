package com.dbattisti.echoclient;

public class EchoClientApp 
{
    public static void main( String[] args )
    {
        new EchoClient("localhost", 5000).start();
    }
}
