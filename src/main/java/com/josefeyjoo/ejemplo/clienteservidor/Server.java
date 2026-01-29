package com.josefeyjoo.clienteservidor;

import java.io.*;
import java.net.*;

public class Server {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    // Definimos los sockets

    ServerSocket servidor; // Socket de escucha del Servidor
    Socket cliente; // Socket para atender a un cliente
    int numCliente = 0; // Contador de clientes
    int PUERTO = 5000; // Puerto para escuchar

    System.out.println("Soy el servidor y empiezo a escuchar peticiones por el puerto:" + PUERTO);
    // Apertura de socket para escuchar a travs de un puerto
    try {
      servidor = new ServerSocket(PUERTO);
      // Atendemos a los clientes
      do {
        numCliente++;
        // Aceptamos la conexin
        cliente = servidor.accept();
        System.out.println("\t Llega el cliente: " + numCliente);
        DataOutputStream dos = new DataOutputStream(cliente.getOutputStream());
        dos.writeUTF("Eres el cliente: " + numCliente);
        // Y cerramos la conexin porque ya no vamos a operar ms con l
        cliente.close();
        System.out.println("\t Se ha cerrado la conexin con el cliente: " + numCliente);
      } while (true);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
