package com.pucrs;

import java.io.*;
import java.net.*;

public class TCPClient {
    public static void main(String argv[]) throws Exception {

        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));

        Socket clientSocket = new Socket("localhost", 6786);

        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());

        String sentence = inFromUser.lines().collect(Collectors.joining());

        outToServer.writeBytes(sentence);

        clientSocket.close();
    }
}
