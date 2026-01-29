package com.josefeyjoo.actividades3.actividad2;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Cliente {
  public static void main(String[] args) throws UnknownHostException, IOException {
    // NOTE: El cliente recibe un mensaje y lo devuelve en minusculas
    //
    final int PUERTO = 5001;

    Socket server = new Socket("localhost", PUERTO);

    DataInputStream flujoEntrada;
    DataOutputStream flujoSalida;

    flujoEntrada = new DataInputStream(server.getInputStream());

    String mensajeRecibido = flujoEntrada.readUTF();

    flujoSalida = new DataOutputStream(server.getOutputStream());

    flujoSalida.writeUTF(devolverMensajeMinusculas(mensajeRecibido));

    flujoSalida.close();
    flujoEntrada.close();
    server.close();
  }

  public static String devolverMensajeMinusculas(String mensaje) {
    return mensaje.toLowerCase();
  }
}
