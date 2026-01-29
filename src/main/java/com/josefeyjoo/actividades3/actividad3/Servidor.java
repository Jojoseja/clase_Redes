package com.josefeyjoo.actividades3.actividad3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {
  public static void main(String[] args) throws IOException {
    // Puerto del Servidor
    final int PUERTO = 5001;

    ServerSocket servidor = new ServerSocket(PUERTO);

    System.out.println("Iniciado el servidor en el puerto: " + servidor.getLocalPort());

    Socket cliente = servidor.accept();
    System.out.println("Conectado con el cliente en el puerto: " + cliente.getPort());

    DataInputStream flujoEntrada;
    flujoEntrada = new DataInputStream(cliente.getInputStream());
    DataOutputStream flujoSalida;

    int numeroRecibido = flujoEntrada.read();
    System.out.println("Se ha recibido el numero: " + numeroRecibido);

    int numeroCuadrado = devolverCuadrado(numeroRecibido);
    flujoSalida = new DataOutputStream(cliente.getOutputStream());
    flujoSalida.writeInt(numeroCuadrado);
    System.out.println("Se ha enviado el numero: " + numeroCuadrado);

    flujoSalida.close();
    flujoEntrada.close();
    cliente.close();
    servidor.close();

  }

  public static int devolverCuadrado(int numero) {
    return numero * numero;
  }
}
