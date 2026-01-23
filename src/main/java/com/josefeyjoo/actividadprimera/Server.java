package com.josefeyjoo.actividadprimera;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
  public static void main(String[] args) throws IOException {
    int port = 5001;
    ServerSocket serversocket = new ServerSocket(port);

    System.out.printf("Escuchando en el puerto: %d\n", serversocket.getLocalPort());

    Socket client1 = serversocket.accept();
    System.out.println("Aceptado el cliente 1");

    Socket client2 = serversocket.accept();
    System.out.println("Aceptado el cliente 2");

  }
}
