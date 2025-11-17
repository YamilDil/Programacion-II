package exa;
public class Persona {
    private String nombre;
    private int edad;
    private float pesoPersona;

    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = peso;
    }

    @Override
    public String toString() {
        return nombre + " (" + edad + " años, " + pesoPersona + "kg)";
    }
}
