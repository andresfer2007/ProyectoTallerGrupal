package ejecutarjuego;

import java.util.ArrayList;

public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int vidaMaxima;
    protected int nivel;
    protected int victorias;

    protected int energia;
    protected int cooldown;

    // estados alterados del personaje
    protected ArrayList<IEstadoAlterado> estadosAlterados;

    public Personaje(String nombre, int vida, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.nivel = nivel;
        this.victorias = 0;

        this.energia = 100;
        this.cooldown = 0;

        this.estadosAlterados = new ArrayList<IEstadoAlterado>();
    }

    public void sumarVictoria() {
        victorias++;
    }

    public int getVictorias() {
        return victorias;
    }

    public void restaurarVida() {
        vida = vidaMaxima;
    }

    public abstract int atacar();

    public abstract int defender();

    public abstract int usarHabilidadEspecial();

    public void recibirDanio(int danio) {
        vida = vida - danio;

        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void subirNivel() {
        nivel++;
        vidaMaxima = vidaMaxima + 20;
        vida = vidaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    public int getEnergia() {
        return energia;
    }

    public int getCooldown() {
        return cooldown;
    }

    public void recuperarEnergia() {
        energia = energia + 10;

        if (energia > 100) {
            energia = 100;
        }
    }

    public void actualizarCooldown() {
        if (cooldown > 0) {
            cooldown--;
        }
    }

    // control de estados

    public void agregarEstado(IEstadoAlterado estado) {
        estadosAlterados.add(estado);
        System.out.println(nombre + " recibe el estado: " + estado.getNombre());
    }

    public void aplicarEstadosInicioTurno() {
        for (int i = 0; i < estadosAlterados.size(); i++) {
            IEstadoAlterado estado = estadosAlterados.get(i);
            estado.aplicarInicioTurno(this);
        }
    }

    public boolean puedeAtacar() {
        for (int i = 0; i < estadosAlterados.size(); i++) {
            IEstadoAlterado estado = estadosAlterados.get(i);

            if (estado.permiteAtacar() == false) {
                return false;
            }
        }

        return true;
    }

    public int obtenerAtaqueConEstados(int ataqueBase) {
        int ataqueFinal = ataqueBase;

        for (int i = 0; i < estadosAlterados.size(); i++) {
            IEstadoAlterado estado = estadosAlterados.get(i);
            ataqueFinal = estado.modificarAtaque(ataqueFinal);
        }
        return ataqueFinal;
    }

    public void actualizarEstadosAlterados() {
        ArrayList<IEstadoAlterado> estadosActivos = new ArrayList<IEstadoAlterado>();

        for (int i = 0; i < estadosAlterados.size(); i++) {
            IEstadoAlterado estado = estadosAlterados.get(i);

            estado.reducirDuracion();

            if (estado.estaActivo()) {
                estadosActivos.add(estado);
            } else {
                System.out.println(nombre + " ya no tiene el estado: " + estado.getNombre());
            }
        }
        estadosAlterados = estadosActivos;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nVida: " + vida
                + "\nNivel: " + nivel
                + "\nEnergia: " + energia
                + "\nCooldown: " + cooldown;
    }
}