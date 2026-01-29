package com.josefeyjoo.actividades4.actividad2psp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) {
    // NOTE: puerto en el que se va a abrir el servidor
    int port = 5001;

    // NOTE: Flujo de entrada y salida
    // DataInputStream flujoEntrada;
    // DataOutputStream flujoSalida;

    try (ServerSocket ss = new ServerSocket(port)) {

      Socket cliente = ss.accept();

      // NOTE: Informacion del Cliente
      System.out.println("Se inicia el proceso servidor");
      System.out.println("Datos de la conexion establecida");
      System.out.println("Mi dirección: " + ss.getInetAddress() + " Mi Puerto: " + ss.getLocalPort());
      System.out
          .println("Dirección del cliente: " + cliente.getInetAddress() + " Puerto del Cliente: " + cliente.getPort());

      String mensajeEntrada = "";
      DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());
      DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());

      while (!mensajeEntrada.trim().equals("0")) {
        mensajeEntrada = flujoEntrada.readUTF();
        System.out.println("Se ha recibido el mensaje: " + mensajeEntrada + ", lo duplicamos y enviamos");
        flujoSalida.writeUTF(devolverDoble(mensajeEntrada));
      }
      System.out.println("El cliente ha cerrado la conexion");
      flujoEntrada.close();
      flujoSalida.close();

    } catch (Exception e) {
      System.out.println(e.getMessage());
    }
  }

  public static String devolverDoble(String numero) {
    int numeroInt = Integer.parseInt(numero);
    return String.valueOf(numeroInt * 2);
  }

}
