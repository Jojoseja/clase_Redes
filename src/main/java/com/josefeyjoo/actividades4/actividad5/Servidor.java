package com.josefeyjoo.actividades4.actividad5;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) {
    // static int maximoHilos = args[0];

    final int PUERTO = 5001;
    try (ServerSocket servidor = new ServerSocket(PUERTO)) {
      System.out.println("Servidor creado en: " + servidor.getLocalPort());
      while (true) {
        Socket cliente = servidor.accept();
        new HiloCliente(cliente).start();
        System.out
            .println("Cliente Aceptado con Direccion: " + cliente.getInetAddress() + " y Puerto: " + cliente.getPort());
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
