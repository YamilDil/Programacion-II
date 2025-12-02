package Practica6;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("INICIO DE LA EJECUCIÓN DE PRUEBA\n");

        Autor autor1 = new Autor("Gabriel García Márquez", "Colombiana");
        Autor autor2 = new Autor("Isabel Allende", "Chilena");

        List<String> paginas1 = Arrays.asList("En un lugar de Macondo...", "Página 2 contenido...", "Página 3 contenido...");
        List<String> paginas2 = Arrays.asList("Prólogo...", "Capítulo 1...", "Capítulo 2...");

        Libro libro1 = new Libro("Cien Años de Soledad", "ISBN-1111", paginas1);
        Libro libro2 = new Libro("La Casa de los Espíritus", "ISBN-2222", paginas2);

        Estudiante est1 = new Estudiante("2025001", "Ana Pérez");
        Estudiante est2 = new Estudiante("2025002", "Luis Gómez");

        Biblioteca biblio = new Biblioteca("Biblioteca UMSA",
                Arrays.asList("Lunes", "Martes", "Miércoles", "Jueves", "Viernes"),
                "08:00", "18:00");

        biblio.mostrarEstado();

        biblio.agregarAutor(autor1);
        biblio.agregarAutor(autor2);
        biblio.agregarLibro(libro1);
        biblio.agregarLibro(libro2);

        biblio.mostrarEstado();

        libro1.leer();

        biblio.prestarLibro(est1, libro1);
        biblio.prestarLibro(est2, libro2);

        biblio.mostrarEstado();

        biblio.cerrarBiblioteca();
        biblio.mostrarEstado();

        System.out.println("FIN DE LA EJECUCIÓN DE PRUEBA");
    }
}
