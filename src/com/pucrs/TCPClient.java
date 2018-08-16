package com.pucrs;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Socket clientSocket = new Socket("localhost", 6786);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        String sentence = inFromUser.readLine();

        outToServer.write(sentence.getBytes());

        clientSocket.close();
    }
}