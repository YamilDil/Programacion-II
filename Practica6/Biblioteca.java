package Practica6;

import java.util.*;

public class Biblioteca {
    private String nombre;
    private List<Libro> libros;
    private List<Autor> autores;
    private List<Prestamo> prestamos;
    private Horario horario;
    private boolean abierta;

    // --- Clase interna (Composición) ---
    public class Horario {
        private List<String> diasApertura;
        private String horaApertura;
        private String horaCierre;

        public Horario(List<String> diasApertura, String horaApertura, String horaCierre) {
            this.diasApertura = diasApertura;
            this.horaApertura = horaApertura;
            this.horaCierre = horaCierre;
        }

        public String mostrarHorario() {
            return "Días: " + String.join(", ", diasApertura) +
                    " | Apertura: " + horaApertura + " | Cierre: " + horaCierre;
        }
    }

    public Biblioteca(String nombre, List<String> diasApertura, String horaApertura, String horaCierre) {
        this.nombre = nombre;
        this.libros = new ArrayList<>();
        this.autores = new ArrayList<>();
        this.prestamos = new ArrayList<>();
        this.horario = new Horario(diasApertura, horaApertura, horaCierre);
        this.abierta = true;
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        System.out.println("[Biblioteca] Libro agregado: " + libro.getTitulo());
    }

    public void agregarAutor(Autor autor) {
        autores.add(autor);
        System.out.println("[Biblioteca] Autor registrado: " + autor.getNombre());
    }

    public void prestarLibro(Estudiante estudiante, Libro libro) {
        if (!abierta) {
            System.out.println("[Biblioteca] No se puede prestar: biblioteca cerrada.");
            return;
        }
        Prestamo p = new Prestamo(estudiante, libro);
        prestamos.add(p);
        System.out.println("[Biblioteca] Préstamo creado: " + p.mostrarInfo());
    }

    public void mostrarEstado() {
        System.out.println("=== Estado de la Biblioteca: " + nombre + " ===");
        if (horario != null)
            System.out.println("Horario: " + horario.mostrarHorario());
        else
            System.out.println("Horario: (no disponible - biblioteca cerrada)");

        System.out.println("\nAutores registrados:");
        if (autores.isEmpty()) System.out.println(" (sin autores)");
        else for (Autor a : autores) System.out.println(" - " + a.mostrarInfo());

        System.out.println("\nLibros disponibles:");
        if (libros.isEmpty()) System.out.println(" (sin libros)");
        else for (Libro l : libros) System.out.println(" - " + l);

        System.out.println("\nPréstamos activos:");
        if (prestamos.isEmpty()) System.out.println(" (sin préstamos)");
        else for (Prestamo p : prestamos) System.out.println(" - " + p.mostrarInfo());

        System.out.println("=========================================\n");
    }
    public void cerrarBiblioteca() {
        System.out.println("[Biblioteca] Cerrando la biblioteca " + nombre + "...");
        abierta = false;
        int num = prestamos.size();
        prestamos.clear();
        horario = null; // Composición: desaparece con la biblioteca
        System.out.println("[Biblioteca] Se eliminaron " + num + " préstamos. El horario ya no existe.\n");
    }
}
