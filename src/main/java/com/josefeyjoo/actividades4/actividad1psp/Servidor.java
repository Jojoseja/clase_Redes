package com.josefeyjoo.actividad1psp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) {
    // NOTE: puerto en el que se va a abrir el servidor
    int port = 5001;

    DataInputStream dis;
    DataOutputStream dos;

    try (ServerSocket ss = new ServerSocket(port)) {

      Socket cliente = ss.accept();

      System.out.println("Se inicia el proceso servidor");
      System.out.println("Datos de la conexion establecida");
      System.out.println("Mi dirección: " + ss.getInetAddress());
      System.out.println("Mi puerto: " + ss.getLocalPort());
      System.out.println("Dirección del cliente: " + cliente.getInetAddress());
      System.out.println("Puerto del cliente: " + cliente.getPort());

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
