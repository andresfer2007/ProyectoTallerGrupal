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
public class MenuDelDia extends Menu {
 
    private double valorPostre;
    private double valorBebida;
 
    public MenuDelDia(String nombrePlato, double valorInicial,
                      double valorPostre, double valorBebida) {
        super(nombrePlato, valorInicial);
        this.valorPostre = valorPostre;
        this.valorBebida = valorBebida;
        calcularValorMenu();
    }
 
    @Override
    public void calcularValorMenu() {
        valorMenu = valorInicial + valorPostre + valorBebida;
    }
 
    @Override
    public String toString() {
        return String.format(
            "  [Menú del Día]\n" +
            "    Plato         : %s\n" +
            "    Valor inicial : $%.2f\n" +
            "    Postre        : $%.2f\n" +
            "    Bebida        : $%.2f\n" +
            "    Valor menú    : $%.2f",
            nombrePlato, valorInicial, valorPostre, valorBebida, valorMenu
        );
    }
}
