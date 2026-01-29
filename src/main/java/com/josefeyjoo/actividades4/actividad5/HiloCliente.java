package com.josefeyjoo.actividades4.actividad5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.Semaphore;

public class HiloCliente extends Thread {
  static Semaphore semaforo = new Semaphore(2);// Mas adelante agregar el valor de la variable
  Socket cliente;

  public HiloCliente(Socket cliente) {
    this.cliente = cliente;
  }

  public String respuestaCliente(String mensaje) {
    DateTimeFormatter dtfFecha = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    DateTimeFormatter dtfHora = DateTimeFormatter.ofPattern("HH:mm:ss");
    switch (mensaje) {
      case "F":
        LocalDate fecha = LocalDate.now();
        return fecha.format(dtfFecha);
      case "H":
        LocalTime hora = LocalTime.now();
        return hora.format(dtfHora);
      default:
        return "ERROR";
    }

  }

  @Override
  public void run() {
    try {
      semaforo.acquire();
      DataInputStream flujoEntrada = new DataInputStream(cliente.getInputStream());
      DataOutputStream flujoSalida = new DataOutputStream(cliente.getOutputStream());

      String mensajeCliente;
      String mensajeRespuesta;

      do {
        mensajeCliente = flujoEntrada.readUTF();

        mensajeRespuesta = respuestaCliente(mensajeCliente);

        flujoSalida.writeUTF(mensajeRespuesta);
        System.out.println(semaforo.availablePermits());
      } while (!mensajeCliente.equals("0"));

      flujoEntrada.close();
      flujoSalida.close();
    } catch (Exception e) {
      e.printStackTrace();
    } finally {
      try {
        semaforo.release();
        cliente.close();
      } catch (IOException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
  }
}
