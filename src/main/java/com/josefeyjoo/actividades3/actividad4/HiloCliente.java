package com.josefeyjoo.actividades3.actividad4;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class HiloCliente extends Thread {
  // TODO: Change MAX_NUMBER_OF_CLIENTS later to an argument
  public static int MAX_NUMBER_OF_CLIENTS = 3;
  private final static Semaphore semaphore = new Semaphore(MAX_NUMBER_OF_CLIENTS);
  private final static AtomicInteger CLIENT_COUNTER = new AtomicInteger(0);
  private final static AtomicInteger ACTIVE_THREAD = new AtomicInteger();

  private final int clientNumber;
  int threadNumber;
  private final Socket cliente;

  public HiloCliente(Socket cliente) {
    this.cliente = cliente;
    this.clientNumber = CLIENT_COUNTER.incrementAndGet();
    this.threadNumber = ACTIVE_THREAD.incrementAndGet();
  }

  @Override
  public void run() {
    try {
      semaphore.acquire();
      DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
      DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

      String mensajeRecibido;
      while ((mensajeRecibido = flujoEntrada.readUTF()) != "*") {
        flujoSalida.writeUTF("lol");
        flujoSalida.flush();
        System.out.printf("El cliente, %d, hilo: %d ha escrito algo \n", clientNumber, threadNumber);
        System.out.println("Mensaje: " + mensajeRecibido);
      }
    } catch (InterruptedException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } finally {
      semaphore.release();
      try {
        cliente.close();
      } catch (Exception e) {
        System.out.println("Error closing the client's socket");
      }
    }
  }
}
