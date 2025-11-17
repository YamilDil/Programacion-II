package exa;
public class Cabina {
    private int nroCabina;
    private Persona[] personasAbordo;
    private int cantidadPersonas;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new Persona[10];
        this.cantidadPersonas = 0;
    }

    public void agregarPersona(Persona p) {
        if (cantidadPersonas < personasAbordo.length) {
            personasAbordo[cantidadPersonas++] = p;
        } else {
            System.out.println("Cabina " + nroCabina + " llena");
        }
    }

    @Override
    public String toString() {
        String s = "Cabina " + nroCabina + ": ";
        for (int i = 0; i < cantidadPersonas; i++) {
            s += personasAbordo[i] + " ";
        }
        return s;
    }
}
