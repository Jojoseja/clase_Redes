package com.josefeyjoo.actividades3.actividad2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) throws IOException {
    // NOTE: El servidor envía un mensaje al cliente, el cliente lo devuelve en
    // minusculas (y el servidor lo lee de vuelta)

    // NOTE: Puerto en el que va a estar escuchando el servidor
    final int PUERTO = 5001;

    try (ServerSocket server = new ServerSocket(PUERTO)) {
      System.out.println("Iniciando Servidor en el puerto: " + server.getLocalPort());

      // NOTE: Flujos de entrada y salida
      DataOutputStream flujoSalida;
      DataInputStream flujoEntrada;

      Socket cliente = server.accept();

      // NOTE: Mensaje a enviar
      String mensaje = "HOLA BUENOS DIAS";

      System.out.println("Mensaje enviado: " + mensaje);

      flujoSalida = new DataOutputStream(cliente.getOutputStream());

      flujoSalida.writeUTF(mensaje);

      flujoEntrada = new DataInputStream(cliente.getInputStream());

      String mensajeRecibido = flujoEntrada.readUTF();

      System.out.println("Este es el mensaje recibido: " + mensajeRecibido);

      flujoEntrada.close();
      flujoSalida.close();
    }

  }
}
