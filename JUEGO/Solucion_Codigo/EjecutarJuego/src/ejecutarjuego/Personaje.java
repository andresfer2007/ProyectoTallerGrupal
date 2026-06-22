package ejecutarjuego;
public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int vidaMaxima;
    protected int nivel;
    protected int victorias;

    public Personaje(String nombre, int vida, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.nivel = nivel;
        this.victorias = 0;
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

    public void recibirDanio(int danio) {
        vida -= danio;

        if (vida < 0) {
            vida = 0;
        }
    }

    public boolean estaVivo() {
        return vida > 0;
    }

    public void subirNivel() {
        nivel++;
        vidaMaxima += 20;
        vida = vidaMaxima;
    }

    public String getNombre() {
        return nombre;
    }

    public int getVida() {
        return vida;
    }

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nVida: " + vida
                + "\nNivel: " + nivel;
    }
}