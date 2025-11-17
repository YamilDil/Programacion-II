package exa;
public class MiTeleferico {
    private Linea[] lineas;
    private float cantidadIngresos;
    private int cantidadLineas;

    public MiTeleferico() {
        this.lineas = new Linea[10];
        this.cantidadLineas = 0;
        this.cantidadIngresos = 0;
    }

    public void agregarLinea(String color) {
        if (cantidadLineas < lineas.length) {
            lineas[cantidadLineas++] = new Linea(color);
        }
    }

    public void agregarPersonaFila(Persona p, String colorLinea) {
        for (int i = 0; i < cantidadLineas; i++) {
            if (lineas[i].toString().contains(colorLinea)) {
                lineas[i].agregarPersona(p);
                cantidadIngresos += 3.0;  // ejemplo
                return;
            }
        }
        System.out.println("No existe la línea: " + colorLinea);
    }

    public void agregarCabina(String colorLinea) {
        for (int i = 0; i < cantidadLineas; i++) {
            if (lineas[i].toString().contains(colorLinea)) {
                lineas[i].agregarCabina(i + 1);
                return;
            }
        }
        System.out.println("No existe la línea: " + colorLinea);
    }

    @Override
    public String toString() {
        String s = "Mi Teleférico:\n";
        for (int i = 0; i < cantidadLineas; i++) {
            s += lineas[i].toString() + "\n";
        }
        s += "Ingresos: Bs. " + cantidadIngresos;
        return s;
    }
}
