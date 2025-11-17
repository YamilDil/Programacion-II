class Persona {
    String nombre;
    int edad;
    float pesoPersona;

    public Persona(String nombre, int edad, float peso) {
        this.nombre = nombre;
        this.edad = edad;
        this.pesoPersona = peso;
    }
}

class Cabina {
    int nroCabina;
    Persona[] personasAbordo;

    public Cabina(int nroCabina) {
        this.nroCabina = nroCabina;
        this.personasAbordo = new Persona[10]; // max 10 personas
    }

    public boolean agregarPersona(Persona p) {
        for (int i = 0; i < personasAbordo.length; i++) {
            if (personasAbordo[i] == null) {
                personasAbordo[i] = p;
                return true;
            }
        }
        return false;
    }

    public float pesoTotal() {
        float t = 0;
        for (Persona p : personasAbordo) {
            if (p != null) t += p.pesoPersona;
        }
        return t;
    }

    public int cantidadPersonas() {
        int c = 0;
        for (Persona p : personasAbordo) {
            if (p != null) c++;
        }
        return c;
    }
}

class Linea {
    String color;
    Persona[] filaPersonas;
    Cabina[] cabinas;
    int cantidadCabinas;

    public Linea(String color) {
        this.color = color;
        this.filaPersonas = new Persona[100];
        this.cabinas = new Cabina[20];
        this.cantidadCabinas = 0;
    }

    public void agregarPersona(Persona p) {
        for (int i = 0; i < filaPersonas.length; i++) {
            if (filaPersonas[i] == null) {
                filaPersonas[i] = p;
                break;
            }
        }
    }

    public void agregarCabina(int nro) {
        cabinas[cantidadCabinas] = new Cabina(nro);
        cantidadCabinas++;
    }

    // saca primera persona de la fila
    public Persona obtenerPrimeraPersona() {
        for (int i = 0; i < filaPersonas.length; i++) {
            if (filaPersonas[i] != null) {
                Persona p = filaPersonas[i];
                filaPersonas[i] = null;
                return p;
            }
        }
        return null;
    }

    public Cabina getCabina(int nro) {
        for (int i = 0; i < cantidadCabinas; i++) {
            if (cabinas[i].nroCabina == nro) return cabinas[i];
        }
        return null;
    }
}

class MiTeleferico {
    Linea[] lineas;
    float cantidadIngresos;

    public MiTeleferico() {
        lineas = new Linea[3];
        lineas[0] = new Linea("Amarillo");
        lineas[1] = new Linea("Rojo");
        lineas[2] = new Linea("Verde");
    }

    public Linea buscarLinea(String color) {
        for (Linea l : lineas) {
            if (l.color.equalsIgnoreCase(color)) return l;
        }
        return null;
    }

    public void agregarPersonaFila(Persona p, String linea) {
        Linea l = buscarLinea(linea);
        if (l != null) l.agregarPersona(p);
    }

    public void agregarCabina(String linea) {
        Linea l = buscarLinea(linea);
        if (l != null) l.agregarCabina(l.cantidadCabinas + 1);
    }

    // (a)
    public boolean agregarPrimeraPersonaACabina(String linea, int nroCab) {
        Linea l = buscarLinea(linea);
        if (l == null) return false;

        Persona p = l.obtenerPrimeraPersona();
        if (p == null) return false;

        Cabina c = l.getCabina(nroCab);
        if (c == null) return false;

        if (c.cantidadPersonas() >= 10) return false;
        if (c.pesoTotal() + p.pesoPersona > 850) return false;

        return c.agregarPersona(p);
    }

    // (b)
    public void verificarReglas() {
        for (Linea l : lineas) {
            for (int i = 0; i < l.cantidadCabinas; i++) {
                Cabina c = l.cabinas[i];
                boolean ok = (c.cantidadPersonas() <= 10 &&
                              c.pesoTotal() <= 850);

                System.out.println(l.color + " Cabina " + c.nroCabina +
                        " cumple reglas? " + ok);
            }
        }
    }

    // preferencia
    private boolean esPreferencia(Persona p) {
        return p.edad <= 25 || p.edad >= 60;
    }

    // (c)
    public float ingresoTotal() {
        float total = 0;
        for (Linea l : lineas) {
            for (int i = 0; i < l.cantidadCabinas; i++) {
                Cabina c = l.cabinas[i];
                for (Persona p : c.personasAbordo) {
                    if (p != null) {
                        if (esPreferencia(p)) total += 1.5f;
                        else total += 3f;
                    }
                }
            }
        }
        return total;
    }

    // (d)
    public String lineaMayorRegular() {
        float max = -1;
        String mejor = "";

        for (Linea l : lineas) {
            float ingreso = 0;

            for (int i = 0; i < l.cantidadCabinas; i++) {
                Cabina c = l.cabinas[i];
                for (Persona p : c.personasAbordo) {
                    if (p != null && !esPreferencia(p)) {
                        ingreso += 3;
                    }
                }
            }

            if (ingreso > max) {
                max = ingreso;
                mejor = l.color;
            }
        }
        return mejor;
    }
}

// =============================
//         MAIN 
// =============================
public class Main {
    public static void main(String[] args) {

        MiTeleferico mt = new MiTeleferico();

        // agregar cabinas
        mt.agregarCabina("Amarillo");
        mt.agregarCabina("Amarillo");
        mt.agregarCabina("Rojo");
        mt.agregarCabina("Verde");

        // agregar personas a la fila
        mt.agregarPersonaFila(new Persona("Ana", 20, 55), "Amarillo");  // preferencia
        mt.agregarPersonaFila(new Persona("Luis", 30, 80), "Amarillo"); // regular
        mt.agregarPersonaFila(new Persona("Pedro", 65, 70), "Amarillo"); // preferencia

        mt.agregarPersonaFila(new Persona("Maria", 22, 60), "Rojo");
        mt.agregarPersonaFila(new Persona("Jose", 40, 90), "Rojo");

        // (a)
        System.out.println("\n(a) Embarcando personas...");
        mt.agregarPrimeraPersonaACabina("Amarillo", 1);
        mt.agregarPrimeraPersonaACabina("Amarillo", 1);
        mt.agregarPrimeraPersonaACabina("Amarillo", 2);

        // (b)
        System.out.println("\n(b) Verificación de reglas:");
        mt.verificarReglas();

        // (c)
        System.out.println("\n(c) Ingreso total del sistema:");
        System.out.println(mt.ingresoTotal() + " bs");

        // (d)
        System.out.println("\n(d) Línea con MAYOR ingreso regular:");
        System.out.println(mt.lineaMayorRegular());
    }
}
