package com.pucrs;


// L� uma linha do teclado
// Envia o pacote (linha digitada) ao servidor

import java.io.*; // classes para input e output streams e
import java.net.*;// DatagramaSocket,InetAddress,DatagramaPacket
import java.util.stream.Collectors;

public class UDPClient {
    public static void main(String args[]) throws Exception
    {
        // cria o stream do teclado
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(new FileInputStream("test.txt")));

        // declara socket cliente
        DatagramSocket clientSocket = new DatagramSocket();

        // obtem endere�o IP do servidor com o DNS
        InetAddress IPAddress = InetAddress.getByName("localhost");

        byte[] sendData = new byte[1024];

        // l� uma linha do teclado
        String sentence = inFromUser.lines().collect(Collectors.joining());
        sendData = sentence.getBytes();

        // cria pacote com o dado, o endere�o do server e porta do servidor
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, 9876);

        //envia o pacote
        clientSocket.send(sendPacket);

        inFromUser.close();
        // fecha o cliente
        clientSocket.close();
    }
}

