package com.josefeyjoo.actividad1psp;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
  public static void main(String[] args) {
    final int PUERTO = 5001;

    Socket server;
    try {
      server = new Socket("127.0.0.1", PUERTO);
      System.out.println("Se inicia el proceso Cliente");
      System.out.println("Datos de la conexion establecida: ");
      System.out.println("Direccion del servidor" + server.getInetAddress());
      System.out.println("Mi puerto " + server.getLocalPort());
      System.out.printf("Puerto del servidor: %d \n", PUERTO);
    } catch (UnknownHostException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
