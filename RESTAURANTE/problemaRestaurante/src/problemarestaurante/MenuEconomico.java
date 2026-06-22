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
public class MenuEconomico extends Menu {
 
    private double porcentajeDescuento;
 
    public MenuEconomico(String nombrePlato, double valorInicial,
                         double porcentajeDescuento) {
        super(nombrePlato, valorInicial);
        this.porcentajeDescuento = porcentajeDescuento;
        calcularValorMenu();
    }
 
    @Override
    public void calcularValorMenu() {
        double descuento = valorInicial * (porcentajeDescuento / 100.0);
        valorMenu = valorInicial - descuento;
    }
 
    @Override
    public String toString() {
        return String.format(
            "  [Menú Económico]\n" +
            "    Plato         : %s\n" +
            "    Valor inicial : $%.2f\n" +
            "    %% Descuento  : %.1f%%\n" +
            "    Valor menú    : $%.2f",
            nombrePlato, valorInicial, porcentajeDescuento, valorMenu
        );
    }
}
