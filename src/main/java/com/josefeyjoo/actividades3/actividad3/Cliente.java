package com.josefeyjoo.actividades3.actividad3;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Cliente {
  public static void main(String[] args) {
    // NOTE: El cliente envia un numero y el servidor lo devuelve al cuadrado

    // NOTE: PUERTO PARA EL SERVIDOR
    final int PUERTO = 5001;

    try (Socket servidor = new Socket("localhost", PUERTO)) {
      System.out.println("Conexión realizada en: " + servidor.getInetAddress() + " puerto: " + servidor.getPort());

      Scanner sc = new Scanner(System.in);
      DataOutputStream flujoSalida;
      DataInputStream flujoEntrada;

      // Introducir Numero
      System.out.println("Introduce un numero: ");
      int numero = sc.nextInt();

      // Enviar numero
      flujoSalida = new DataOutputStream(servidor.getOutputStream());
      flujoSalida.write(numero);
      System.out.println("Se ha enviado el numero: " + numero);

      flujoEntrada = new DataInputStream(servidor.getInputStream());
      int numeroCuadrado = flujoEntrada.readInt();
      System.out.println("Se ha recibido el numero: " + numeroCuadrado);

      sc.close();
      flujoEntrada.close();
      flujoSalida.close();

    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
