package ejecutarjuego;

public class Mago extends Personaje {

    private int magia;

    public Mago(String nombre, int vida, int nivel, int magia) {
        super(nombre, vida, nivel);
        this.magia = magia;
    }

    @Override
    public int atacar() {
        return (magia * nivel) + getBonusAtaque();
    }

    @Override
    public int defender() {
        return 3 + getBonusDefensa();
    }

    @Override
    public String toString() {
        return "\n--- MAGO ---"
                + "\n" + super.toString()
                + "\nMagia: " + magia;
    }
}
