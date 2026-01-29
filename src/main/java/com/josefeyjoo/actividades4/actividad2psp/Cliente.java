package com.josefeyjoo.actividades4.actividad2psp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    final int PUERTO = 5001;

    Socket server;
    try {
      server = new Socket("127.0.0.1", PUERTO);

      System.out.println("Se inicia el proceso Cliente");
      System.out.println("Datos de la conexion establecida: ");
      System.out.println("Mi direccion: " + server.getInetAddress() + "Mi puerto: " + server.getLocalPort());

      String mensaje = "";

      // NOTE: Scanner, DataInputStream, DataOutputStream
      Scanner sc = new Scanner(System.in);
      DataOutputStream flujoSalida = new DataOutputStream(server.getOutputStream());
      DataInputStream flujoEntrada = new DataInputStream(server.getInputStream());

      do {
        System.out.println("Introduce un mensaje: ");

        mensaje = sc.nextLine();
        flujoSalida.writeUTF(mensaje);

        String recibir = flujoEntrada.readUTF();
        System.out.println(recibir);
      } while (!mensaje.trim().equals("0"));
    } catch (Exception e) {
      System.out.println("Error" + e.getMessage());
    }
  }
}
