/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemarestaurante;

import java.util.ArrayList;

/**
 * Cuenta de un cliente en el restaurante.
 * Contiene una lista de objetos Menu (polimorfismo).
 */
public class CuentaRestaurante {

    private String nombreCliente;
    private ArrayList<Menu> listaMenus;
    private double subtotal;
    private double iva;
    private double totalAPagar;

    private static final double PORCENTAJE_IVA = 12.0; // IVA Ecuador

    public CuentaRestaurante(String nombreCliente) {
        this.nombreCliente = nombreCliente;
        this.listaMenus    = new ArrayList<>();
    }

    public void agregarMenu(Menu menu) {
        listaMenus.add(menu);
    }

    public void calcularCuenta() {
        subtotal = 0;
        for (Menu m : listaMenus) {
            subtotal += m.getValorMenu(); // polimorfismo: cada getValorMenu() es distinto
        }
        iva        = subtotal * (PORCENTAJE_IVA / 100.0);
        totalAPagar = subtotal + iva;
    }

    // Getters
    public String getNombreCliente() { return nombreCliente; }
    public double getSubtotal()      { return subtotal;      }
    public double getIva()           { return iva;           }
    public double getTotalAPagar()   { return totalAPagar;   }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("============================================\n");
        sb.append("        CUENTA DEL RESTAURANTE\n");
        sb.append("============================================\n");
        sb.append(String.format("Cliente : %s%n", nombreCliente));
        sb.append("--------------------------------------------\n");
        sb.append("DETALLE DE MENÚS:\n");
        for (Menu m : listaMenus) {
            sb.append(m.toString()).append("\n"); // toString() polimórfico
            sb.append("  ------------------------------------------\n");
        }
        sb.append(String.format("Subtotal      : $%.2f%n", subtotal));
        sb.append(String.format("IVA (%.0f%%)    : $%.2f%n", PORCENTAJE_IVA, iva));
        sb.append("============================================\n");
        sb.append(String.format("TOTAL A PAGAR : $%.2f%n", totalAPagar));
        sb.append("============================================\n");
        return sb.toString();
    }
}
