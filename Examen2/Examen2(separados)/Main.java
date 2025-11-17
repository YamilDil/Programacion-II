package exa;
public class Main {
    public static void main(String[] args) {

        MiTeleferico mt = new MiTeleferico();

        mt.agregarLinea("Rojo");
        mt.agregarLinea("Verde");

        Persona p1 = new Persona("Juan", 22, 70);
        Persona p2 = new Persona("Maria", 30, 60);

        mt.agregarPersonaFila(p1, "Rojo");
        mt.agregarPersonaFila(p2, "Rojo");

        mt.agregarCabina("Rojo");
        mt.agregarCabina("Verde");

        System.out.println(mt);
    }
}
