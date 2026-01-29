package com.josefeyjoo.actividades3.actividad4;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) {
    final int PUERTO = 5001;

    HiloCliente.MAX_NUMBER_OF_CLIENTS = Integer.valueOf(args[0]);

    try (ServerSocket servidor = new ServerSocket(PUERTO)) {

      while (true) {
        Socket cliente = servidor.accept();
        new HiloCliente(cliente).start();
      }

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
