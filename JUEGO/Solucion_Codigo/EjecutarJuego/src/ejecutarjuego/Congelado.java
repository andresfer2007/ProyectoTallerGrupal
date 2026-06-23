package ejecutarjuego;

public class Congelado implements IEstadoAlterado {

    private int turnos;

    public Congelado(int turnos) {
        this.turnos = turnos;
    }

    @Override
    public String getNombre() {
        return "Congelado";
    }

    @Override
    public void aplicarInicioTurno(Personaje personaje) {
        System.out.println(personaje.getNombre() + " esta congelado y no puede atacar.");
    }

    @Override
    public int modificarAtaque(int ataqueBase) {
        return ataqueBase;
    }

    @Override
    public boolean permiteAtacar() {
        return false;
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