package Practica6;

import java.util.*;

public class Prestamo {
    private Date fechaPrestamo;
    private Date fechaDevolucion;
    private Estudiante estudiante;
    private Libro libro;

    public Prestamo(Estudiante estudiante, Libro libro) {
        this.estudiante = estudiante;
        this.libro = libro;
        this.fechaPrestamo = new Date();

        Calendar c = Calendar.getInstance();
        c.setTime(fechaPrestamo);
        c.add(Calendar.DATE, 7);
        this.fechaDevolucion = c.getTime();
    }

    public String mostrarInfo() {
        return "Préstamo -> Estudiante: " + estudiante.getNombre() +
                " (Código: " + estudiante.getCodigo() + "), Libro: " + libro.getTitulo() +
                ", Fecha préstamo: " + fechaPrestamo +
                ", Fecha devolución estimada: " + fechaDevolucion;
    }
}
