package com.josefeyjoo.actividades3.actividad1;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {

  public static void main(String[] args) throws UnknownHostException, IOException {
    final int PUERTO = 5001;

    // NOTE: Se nos pide conectar a un servidor

    try (Socket socket = new Socket("localhost", PUERTO)) {
      System.out
          .println("Dirección Cliente es: " + socket.getLocalAddress() + " el puerto es el: " + socket.getLocalPort());
    }
  }

}
