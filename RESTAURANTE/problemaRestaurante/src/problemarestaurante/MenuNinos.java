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
public class MenuNinos extends Menu {
 
    private double valorHelado;
    private double valorPastel;
 
    public MenuNinos(String nombrePlato, double valorInicial,
                     double valorHelado, double valorPastel) {
        super(nombrePlato, valorInicial);
        this.valorHelado = valorHelado;
        this.valorPastel = valorPastel;
        calcularValorMenu();
    }
 
    @Override
    public void calcularValorMenu() {
        valorMenu = valorInicial + valorHelado + valorPastel;
    }
 
    @Override
    public String toString() {
        return String.format(
            "  [Menú de Niños]\n" +
            "    Plato         : %s\n" +
            "    Valor inicial : $%.2f\n" +
            "    Helado        : $%.2f\n" +
            "    Pastel        : $%.2f\n" +
            "    Valor menú    : $%.2f",
            nombrePlato, valorInicial, valorHelado, valorPastel, valorMenu
        );
    }
}
