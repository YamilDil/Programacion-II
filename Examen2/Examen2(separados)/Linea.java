package exa;
public class Linea {
    private String color;
    private Persona[] filaPersonas;
    private Cabina[] cabinas;
    private int cantidadPersonasFila;
    private int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        this.filaPersonas = new Persona[50];
        this.cabinas = new Cabina[20];
        this.cantidadPersonasFila = 0;
        this.cantidadCabinas = 0;
    }

    public void agregarPersona(Persona p) {
        if (cantidadPersonasFila < filaPersonas.length) {
            filaPersonas[cantidadPersonasFila++] = p;
        } else {
            System.out.println("Fila llena en linea " + color);
        }
    }

    public void agregarCabina(int nroCabina) {
        if (cantidadCabinas < cabinas.length) {
            cabinas[cantidadCabinas++] = new Cabina(nroCabina);
        }
    }

    @Override
    public String toString() {
        return "Línea " + color + " | Personas en fila: " + cantidadPersonasFila + " | Cabinas: " + cantidadCabinas;
    }
}
