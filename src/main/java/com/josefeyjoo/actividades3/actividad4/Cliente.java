package com.josefeyjoo.actividades3.actividad4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    final int PUERTO = 5001;

    try (Socket servidor = new Socket("localhost", PUERTO)) {
      System.out.println("Connected to the port: " + PUERTO);
      DataInputStream flujoEntrada = new DataInputStream(servidor.getInputStream());
      DataOutputStream flujoSalida = new DataOutputStream(servidor.getOutputStream());
      Scanner sc = new Scanner(System.in);

      String mensaje = "";

      do {
        mensaje = sc.nextLine();
        // Enviar mensaje
        flujoSalida.writeUTF(mensaje);
        // Recibir mensaje
        String mensajeRecibido = flujoEntrada.readUTF();

        System.out.println("Se ha recibido el mensaje del servidor:" + mensajeRecibido);
      } while (!mensaje.equals("*"));

      flujoSalida.close();
      flujoEntrada.close();
      sc.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
