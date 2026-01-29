package com.josefeyjoo.actividades4.actividad5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    final int PUERTO = 5001;

    try (Socket servidor = new Socket("localhost", PUERTO)) {
      System.out.println(
          "Se ha conectado con el servidor en la direccion: " + servidor.getInetAddress() + " puerto: " + PUERTO);
      DataInputStream flujoEntrada;
      DataOutputStream flujoSalida;

      flujoEntrada = new DataInputStream(servidor.getInputStream());
      flujoSalida = new DataOutputStream(servidor.getOutputStream());
      Scanner sc = new Scanner(System.in);

      String mensaje;
      String mensajeServidor;

      do {
        System.out.println("Que operacion desea realizar:\n'F' para Fecha\n'H' para Hora\n'0' para salir");
        mensaje = sc.nextLine();

        flujoSalida.writeUTF(mensaje);
        System.out.printf("Se ha enviado el mensaje %s \n", mensaje);

        mensajeServidor = flujoEntrada.readUTF();
        System.out.println("Se ha recibido el mensaje : " + mensajeServidor);
      } while (!mensaje.equals("0"));

      sc.close();
      flujoEntrada.close();
      flujoSalida.close();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
