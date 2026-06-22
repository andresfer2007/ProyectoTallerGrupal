/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemarestaurante;

import java.util.Scanner;

/**
 *
 * @author msjim
 */
public class ProblemaRestaurante {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("SISTEMA DE CUENTA - RESTAURANTE  ");

        // 1. Datos del cliente
        System.out.print("Nombre del cliente: ");
        String nombreCliente = sc.nextLine();

        CuentaRestaurante cuenta = new CuentaRestaurante(nombreCliente);

        // 2. Agregar menús en un ciclo
        boolean continuar = true;
        while (continuar) {
            System.out.println("\nTipo de menú a agregar:");
            System.out.println("  1. Menú a la Carta");
            System.out.println("  2. Menú del Día");
            System.out.println("  3. Menú de Niños");
            System.out.println("  4. Menú Económico");
            System.out.println("  0. Finalizar pedido");
            System.out.print("Opción: ");
            int opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1:
                    agregarMenuCarta(sc, cuenta);
                    break;

                case 2:
                    agregarMenuDia(sc, cuenta);
                    break;

                case 3:
                    agregarMenuNinos(sc, cuenta);
                    break;

                case 4:
                    agregarMenuEconomico(sc, cuenta);
                    break;

                case 0:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        // 3. Calcular y mostrar cuenta
        cuenta.calcularCuenta();
        System.out.println("\n" + cuenta.toString());

        sc.close();
    }

    private static void agregarMenuCarta(Scanner sc,
            CuentaRestaurante cuenta) {

        System.out.println("\n=== MENÚ A LA CARTA ===");
        System.out.println("1. Lomo Asado .......... $12.30");
        System.out.println("2. Chuleta ............. $11.75");
        System.out.println("3. Pollo BBQ ........... $10.70");
        System.out.println("4. Costillas ........... $13.90");
        System.out.println("5. Filete de Res ....... $15.50");
        System.out.print("Seleccione una opción: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                cuenta.agregarMenu(
                        new MenuAlaCarta("Lomo Asado",
                                8.00, 2.00, 1.50, 10));
                break;

            case 2:
                cuenta.agregarMenu(
                        new MenuAlaCarta("Chuleta",
                                7.50, 2.00, 1.50, 10));
                break;

            case 3:
                cuenta.agregarMenu(
                        new MenuAlaCarta("Pollo BBQ",
                                7.00, 1.50, 1.50, 10));
                break;

            case 4:
                cuenta.agregarMenu(
                        new MenuAlaCarta("Costillas",
                                9.00, 2.50, 1.50, 10));
                break;

            case 5:
                cuenta.agregarMenu(
                        new MenuAlaCarta("Filete de Res",
                                10.00, 2.50, 2.00, 10));
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    private static void agregarMenuDia(Scanner sc,
            CuentaRestaurante cuenta) {

        System.out.println("\n=== MENÚ DEL DÍA ===");
        System.out.println("1. Sopa de Lenteja + Jugo ........ $4.50");
        System.out.println("2. Arroz con Pollo ............... $5.00");
        System.out.println("3. Seco de Pollo ................. $5.25");
        System.out.println("4. Menestra con Carne ............ $5.50");
        System.out.println("5. Tallarín con Pollo ............ $5.00");
        System.out.print("Seleccione una opción: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                cuenta.agregarMenu(
                        new MenuDelDia("Sopa de Lenteja",
                                3.00, 0.75, 0.75));
                break;

            case 2:
                cuenta.agregarMenu(
                        new MenuDelDia("Arroz con Pollo",
                                3.50, 0.75, 0.75));
                break;

            case 3:
                cuenta.agregarMenu(
                        new MenuDelDia("Seco de Pollo",
                                3.75, 0.75, 0.75));
                break;

            case 4:
                cuenta.agregarMenu(
                        new MenuDelDia("Menestra con Carne",
                                4.00, 0.75, 0.75));
                break;

            case 5:
                cuenta.agregarMenu(
                        new MenuDelDia("Tallarín con Pollo",
                                3.50, 0.75, 0.75));
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    private static void agregarMenuNinos(Scanner sc,
            CuentaRestaurante cuenta) {

        System.out.println("\n=== MENÚ DE NIÑOS ===");
        System.out.println("1. Nuggets con Papas ........ $4.50");
        System.out.println("2. Hamburguesa Infantil ..... $5.00");
        System.out.println("3. Mini Pizza ............... $5.50");
        System.out.println("4. Hot Dog .................. $4.75");
        System.out.println("5. Alitas con Papas ......... $5.25");
        System.out.print("Seleccione una opción: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                cuenta.agregarMenu(
                        new MenuNinos("Nuggets con Papas",
                                3.00, 0.75, 0.75));
                break;

            case 2:
                cuenta.agregarMenu(
                        new MenuNinos("Hamburguesa Infantil",
                                3.50, 0.75, 0.75));
                break;

            case 3:
                cuenta.agregarMenu(
                        new MenuNinos("Mini Pizza",
                                4.00, 0.75, 0.75));
                break;

            case 4:
                cuenta.agregarMenu(
                        new MenuNinos("Hot Dog",
                                3.25, 0.75, 0.75));
                break;

            case 5:
                cuenta.agregarMenu(
                        new MenuNinos("Alitas con Papas",
                                3.75, 0.75, 0.75));
                break;

            default:
                System.out.println("Opción inválida");
        }
    }

    private static void agregarMenuEconomico(Scanner sc,
            CuentaRestaurante cuenta) {

        System.out.println("\n=== MENÚ ECONÓMICO ===");
        System.out.println("1. Arroz con Huevo .......... $2.70");
        System.out.println("2. Menestra Simple .......... $3.15");
        System.out.println("3. Tallarín Económico ....... $2.88");
        System.out.println("4. Sopa + Segundo ........... $3.60");
        System.out.println("5. Encebollado Pequeño ...... $4.05");
        System.out.print("Seleccione una opción: ");

        int op = sc.nextInt();
        sc.nextLine();

        switch (op) {
            case 1:
                cuenta.agregarMenu(
                        new MenuEconomico("Arroz con Huevo",
                                3.00, 10));
                break;

            case 2:
                cuenta.agregarMenu(
                        new MenuEconomico("Menestra Simple",
                                3.50, 10));
                break;

            case 3:
                cuenta.agregarMenu(
                        new MenuEconomico("Tallarín Económico",
                                3.20, 10));
                break;

            case 4:
                cuenta.agregarMenu(
                        new MenuEconomico("Sopa + Segundo",
                                4.00, 10));
                break;

            case 5:
                cuenta.agregarMenu(
                        new MenuEconomico("Encebollado Pequeño",
                                4.50, 10));
                break;

            default:
                System.out.println("Opción inválida");
        }
    }
}
