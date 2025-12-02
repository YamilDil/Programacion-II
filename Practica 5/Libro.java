package Practica6;

import java.util.*;

public class Libro {
    private String titulo;
    private String isbn;
    private List<Pagina> paginas;

    // --- Clase interna (Composición) -------------------  CLASE PAGINA
    public class Pagina {
        private int numero;
        private String contenido;

        public Pagina(int numero, String contenido) {
            this.numero = numero;
            this.contenido = contenido;
        }

        public String mostrar() {
            return "Página " + numero + ": " + contenido;
        }
    }

    public Libro(String titulo, String isbn, List<String> contenidoPaginas) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.paginas = new ArrayList<>();
        for (int i = 0; i < contenidoPaginas.size(); i++) {
            this.paginas.add(new Pagina(i + 1, contenidoPaginas.get(i)));
        }
    }

    public void leer() {
        System.out.println("--- Leyendo '" + titulo + "' (ISBN: " + isbn + ") ---");
        for (Pagina p : paginas) {
            System.out.println(p.mostrar());
        }
    }

    public String getTitulo() { return titulo; }
    public String getIsbn() { return isbn; }

    @Override
    public String toString() {
        return "Libro(título='" + titulo + "', ISBN='" + isbn + "')";
    }
}
