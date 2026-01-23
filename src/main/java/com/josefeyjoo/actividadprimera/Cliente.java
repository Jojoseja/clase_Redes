package com.josefeyjoo.actividadprimera;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
  public static void main(String[] args) throws UnknownHostException, IOException {
    String host = "localhost";
    int port = 5001;
    Socket socket = new Socket(host, port);

    System.out.printf("Conectando al servidor desde el puerto lcoal: %d \n", socket.getLocalPort());
    System.out.printf("Conectado al servidor en %d, puerto %d \n", socket.getInetAddress(), socket.getPort());
    System.out.println("Desconectandose del servidor");
    socket.close();
  }

}
