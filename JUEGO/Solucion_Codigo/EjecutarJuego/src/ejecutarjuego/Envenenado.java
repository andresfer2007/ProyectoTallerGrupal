package ejecutarjuego;

public class Envenenado implements IEstadoAlterado {

    private int turnos;
    private int danioPorTurno;

    public Envenenado(int turnos, int danioPorTurno) {
        this.turnos = turnos;
        this.danioPorTurno = danioPorTurno;
    }

    @Override
    public String getNombre() {
        return "Envenenado";
    }

    @Override
    public void aplicarInicioTurno(Personaje personaje) {
        personaje.recibirDanio(danioPorTurno);
        System.out.println(personaje.getNombre() + " pierde " + danioPorTurno + " de vida por veneno.");
    }

    @Override
    public int modificarAtaque(int ataqueBase) {
        return ataqueBase;
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