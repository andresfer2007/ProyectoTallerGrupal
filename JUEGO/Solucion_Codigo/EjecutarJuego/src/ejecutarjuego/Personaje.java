package ejecutarjuego;
public abstract class Personaje {

    protected String nombre;
    protected int vida;
    protected int vidaMaxima;
    protected int nivel;
    protected int victorias;
    //cambios
    protected int energia;
    protected int cooldown;

    public Personaje(String nombre, int vida, int nivel) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMaxima = vida;
        this.nivel = nivel;
        this.victorias = 0;
        //cambios
        this.energia = 100;
        this.cooldown =0;
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
    //cambios
    public int getEnergia(){
        return energia;
    }
    public int getCooldown(){
        return cooldown;
    }
    
    public abstract int usarHabilidadEspecial();
    public void recuperarEnergia(){
        energia += 10;
        if(energia>100){
            energia =100;
        }
    }      
    public void actualizarCooldown(){
        if(cooldown>0){
            cooldown--;
        }
    }
        

    @Override
    public String toString() {
        return "Nombre: " + nombre
                + "\nVida: " + vida
                + "\nNivel: " + nivel;
    }
}