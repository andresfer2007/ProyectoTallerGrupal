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
public class MenuAlaCarta extends Menu {

    private double valorGuarnicion;
    private double valorBebida;
    private double porcentajeServicio; // % adicional sobre valorInicial

    public MenuAlaCarta(String nombrePlato, double valorInicial,
            double valorGuarnicion, double valorBebida,
            double porcentajeServicio) {
        super(nombrePlato, valorInicial);
        this.valorGuarnicion = valorGuarnicion;
        this.valorBebida = valorBebida;
        this.porcentajeServicio = porcentajeServicio;
        calcularValorMenu();
    }

    @Override
    public void calcularValorMenu() {
        double cargo = valorInicial * (porcentajeServicio / 100.0);
        valorMenu = valorInicial + valorGuarnicion + valorBebida + cargo;
    }

    @Override
    public String toString() {
        return String.format(
                "  [Menú a la Carta]\n"
                + "    Plato         : %s\n"
                + "    Valor inicial : $%.2f\n"
                + "    Guarnición    : $%.2f\n"
                + "    Bebida        : $%.2f\n"
                + "    %% Servicio   : %.1f%%\n"
                + "    Valor menú    : $%.2f",
                nombrePlato, valorInicial, valorGuarnicion,
                valorBebida, porcentajeServicio, valorMenu
        );
    }

}
