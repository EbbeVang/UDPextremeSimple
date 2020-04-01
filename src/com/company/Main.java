package com.company;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Main {


    public static void main(String[] args) throws IOException {
	// write your code here

        // create a socket
        int receivingPort = 7000;
        DatagramSocket receivingSocket = new DatagramSocket(receivingPort);

        // prepare packet
        byte[] bytes = new byte[255];
        DatagramPacket packetToReceive = new DatagramPacket(bytes, bytes.length);

        //wait and receive packet
        receivingSocket.receive(packetToReceive);

        //print packet content
        String message = new String(packetToReceive.getData());
        System.out.println(message);

        //--------------------------------------------------------------

        // create socket
        int sendingPort = 7007;
        DatagramSocket sendingSocket = new DatagramSocket();

        // create packet
        DatagramPacket packetToSend = new DatagramPacket("hello world".getBytes(), 0, 11, InetAddress.getByName("127.0.0.1"), sendingPort);

        //send packet
        sendingSocket.send(packetToSend);



    }


}
