package ejecutarjuego;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EjecutarJuego {

    public static void main(String[] args) {

        Scanner leer = new Scanner(System.in);

        System.out.print("Cuantos personajes participaran en el torneo?: ");
        int cantidad = leerEntero(leer);

        while (cantidad < 2) {
            System.out.print("Se necesitan al menos 2 personajes. Cuantos? ");
            cantidad = leerEntero(leer);
        }

        List<Personaje> participantes = new ArrayList<Personaje>();

        for (int i = 1; i <= cantidad; i++) {
            Personaje p = crearPersonaje(leer, i);
            participantes.add(p);
        }

        System.out.println("\n===== PERSONAJES CREADOS =====");
        for (Personaje p : participantes) {
            System.out.println(p);
        }

        // Estados alterados
        System.out.println("\n===== ESTADOS ALTERADOS APLICADOS =====");
        participantes.get(0).agregarEstado(new Envenenado(3, 5));
        participantes.get(0).agregarEstado(new Congelado(1));
        participantes.get(1).agregarEstado(new AumentoFuerza(2, 10));

        Combate.jugarTorneoTodosContraTodos(participantes);

        leer.close();
    }

    private static Personaje crearPersonaje(Scanner leer, int numero) {

        System.out.println("--- Personaje " + numero + " ---");

        System.out.print("Nombre: ");
        String nombre = leer.nextLine();

        System.out.print("Vida: ");
        int vida = leerEntero(leer);

        int tipo = elegirTipo(leer);

        Personaje personaje;

        switch (tipo) {
            case 1:
                System.out.print("Fuerza: ");
                int fuerza = leerEntero(leer);
                personaje = new Guerrero(nombre, vida, 1, fuerza);
                break;
            case 2:
                System.out.print("Magia: ");
                int magia = leerEntero(leer);
                personaje = new Mago(nombre, vida, 1, magia);
                break;
            default:
                System.out.print("Precision: ");
                int precision = leerEntero(leer);
                personaje = new Arquero(nombre, vida, 1, precision);
                break;
        }

        return personaje;
    }

    private static int elegirTipo(Scanner leer) {

        int opcion = 0;

        while (opcion < 1 || opcion > 3) {

            System.out.println("Elige el tipo de personaje:");
            System.out.println("1. Guerrero");
            System.out.println("2. Mago");
            System.out.println("3. Arquero");
            System.out.print("Opcion: ");

            opcion = leerEntero(leer);

            if (opcion < 1 || opcion > 3) {
                System.out.println("Opcion invalida, intenta de nuevo.\n");
            }
        }

        return opcion;
    }

    private static int leerEntero(Scanner leer) {

        int valor = -1;

        while (valor < 0) {
            try {
                valor = Integer.parseInt(leer.nextLine().trim());

                if (valor < 0) {
                    System.out.print("Ingresa un numero valido: ");
                }
            } catch (NumberFormatException e) {
                System.out.print("Ingresa un numero valido: ");
            }
        }

        return valor;
    }
}