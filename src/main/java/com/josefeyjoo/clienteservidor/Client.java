package com.josefeyjoo.clienteservidor;

import java.io.DataInputStream;
import java.net.*;

public class Client {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Definimos los parmetros de conexin
    InetAddress direccion; // La IP o direin de conexin
    Socket servidor; // Socket para conectarnos a un servidor u otra mquina
    int numCliente = 0; // Nmero de cliente
    int PUERTO = 5000; // Puerto de conexin

    System.out.println("Soy el cliente e intento conectarme");

    try {
      // Vamos a indicar la direccin de conexin
      direccion = InetAddress.getLocalHost(); // direccin local (localhost)
      // Nos conectamos al servidor: direccin y puerto
      servidor = new Socket(direccion, PUERTO);
      // Operamos con la conexin. En este caso recibimos los datos que nos mandan
      System.out.println("Conexin realizada con xito");

      // Es inputStream porque los recibimos
      DataInputStream datos = new DataInputStream(servidor.getInputStream());
      System.out.println(datos.readUTF());
      // Cerramos la conexin
      servidor.close();
      System.out.println("Soy el cliente y cierro la conexin");
    } catch (Exception e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
