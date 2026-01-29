package com.josefeyjoo.actividades3.actividad1;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) throws IOException {
    final int PUERTO = 5001;

    try (ServerSocket servidor = new ServerSocket(PUERTO)) {
      System.out.println("Servidor Direccion: " + servidor.getInetAddress() + " Puerto: " + servidor.getLocalPort());

      Socket cliente1 = servidor.accept();
      System.out.println("Cliente 1 Direcction: " + cliente1.getInetAddress() + " Puerto: " + cliente1.getPort());

      Socket cliente2 = servidor.accept();
      System.out.println("Cliente 2 Direcction: " + cliente2.getInetAddress() + " Puerto: " + cliente2.getPort());
    }
  }
}
