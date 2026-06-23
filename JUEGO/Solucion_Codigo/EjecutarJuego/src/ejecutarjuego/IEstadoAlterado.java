package ejecutarjuego;

public interface IEstadoAlterado {

    String getNombre();

    void aplicarInicioTurno(Personaje personaje);

    int modificarAtaque(int ataqueBase);

    boolean permiteAtacar();

    void reducirDuracion();

    boolean estaActivo();
}