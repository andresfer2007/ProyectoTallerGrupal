/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package problemarestaurante;

/**
 *
 * @author msjim
 */
public abstract class Menu {

    protected String nombrePlato;
    protected double valorInicial;
    protected double valorMenu; // calculado por cada subclase

    public Menu(String nombrePlato, double valorInicial) {
        this.nombrePlato = nombrePlato;
        this.valorInicial = valorInicial;
    }

    // Método abstracto: cada subclase lo implementa diferente → POLIMORFISMO
    public abstract void calcularValorMenu();

    // Getters
    public String getNombrePlato() {
        return nombrePlato;
    }

    public double getValorMenu() {
        return valorMenu;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    // Cada subclase muestra su propia información → POLIMORFISMO
    @Override
    public abstract String toString();
}


