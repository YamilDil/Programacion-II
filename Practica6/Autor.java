package Practica6;

public class Autor {
    private String nombre;
    private String nacionalidad;

    public Autor(String nombre, String nacionalidad) {
        this.nombre = nombre;
        this.nacionalidad = nacionalidad;
    }

    public String mostrarInfo() {
        return "Autor: " + nombre + " (" + nacionalidad + ")";
    }

    public String getNombre() {
        return nombre;
    }
}

