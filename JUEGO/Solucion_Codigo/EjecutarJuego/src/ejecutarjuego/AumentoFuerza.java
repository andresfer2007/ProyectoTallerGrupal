package ejecutarjuego;

public class AumentoFuerza implements IEstadoAlterado {

    private int turnos;
    private int bonoAtaque;

    public AumentoFuerza(int turnos, int bonoAtaque) {
        this.turnos = turnos;
        this.bonoAtaque = bonoAtaque;
    }

    @Override
    public String getNombre() {
        return "Aumento de fuerza";
    }

    @Override
    public void aplicarInicioTurno(Personaje personaje) {
        System.out.println(personaje.getNombre() + " tiene aumento de fuerza activo.");
    }

    @Override
    public int modificarAtaque(int ataqueBase) {
        return ataqueBase + bonoAtaque;
    }

    @Override
    public boolean permiteAtacar() {
        return true;
    }

    @Override
    public void reducirDuracion() {
        turnos--;
    }

    @Override
    public boolean estaActivo() {
        return turnos > 0;
    }
}