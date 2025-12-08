package examen;

import java.io.*;
import java.util.ArrayList;

public class Consultorio {

    private String consultas;
    private String medicos;

    // CONSTRUCTOR
    public Consultorio() {
        // Inicializamos las rutas de los archivos
        this.consultas = "consultas.dat";
        this.medicos = "medicos.dat";
    }

    // MÉTODOS AUXILIARES DE LECTURA/ESCRITURA (Serialización)

    // Guarda la lista completa en el archivo especificado

    private void guardar(String archivo, ArrayList<?> lista) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(archivo))) {
            oos.writeObject(lista);
        } catch (IOException e) {
            System.out.println("Error al guardar: " + e.getMessage());
        }
    }

    // Lee la lista de MEDICOS desde el archivo
    private ArrayList<Medico> leerMedicos() {
        ArrayList<Medico> lista = new ArrayList<>();
        File f = new File(this.medicos); // Usamos el atributo del diagrama
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                lista = (ArrayList<Medico>) ois.readObject();
            } catch (Exception e) {
                // Archivo vacío o error, retornamos lista vacía
            }
        }
        return lista;
    }

    // Lee la lista de CONSULTAS desde el archivo
    private ArrayList<Consulta> leerConsultas() {
        ArrayList<Consulta> lista = new ArrayList<>();
        File f = new File(this.consultas); // Usamos el atributo del diagrama
        if (f.exists()) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
                lista = (ArrayList<Consulta>) ois.readObject();
            } catch (Exception e) {
                // Archivo vacío o error
            }
        }
        return lista;
    }

    // A: DAR DE ALTA (Guardar en archivo)
    public void altaMedico(Medico m) {
        ArrayList<Medico> lista = leerMedicos(); // 1. Traer datos actuales
        lista.add(m);                            // 2. Agregar nuevo
        guardar(this.medicos, lista);            // 3. Guardar de nuevo todo
    }

    public void altaConsulta(Consulta c) {
        ArrayList<Consulta> lista = leerConsultas();
        lista.add(c);
        guardar(this.consultas, lista);
    }

    //  B: DAR DE BAJA (Eliminar Médico y sus consultas)
    public void bajaMedico(String nombreX, String apellidoY) {
        System.out.println("\n>>> PROCESANDO BAJA DE: " + nombreX + " " + apellidoY);

        ArrayList<Medico> listaMedicos = leerMedicos();
        int idEliminar = -1;
        boolean encontrado = false;

        // 1. Buscamos y eliminamos al médico
        for (int i = 0; i < listaMedicos.size(); i++) {
            Medico m = listaMedicos.get(i);
            if (m.getNombreMed().equalsIgnoreCase(nombreX) && m.getApellidoMed().equalsIgnoreCase(apellidoY)) {
                idEliminar = m.getIdMed(); // Guardamos ID para borrar sus citas
                listaMedicos.remove(i);
                encontrado = true;
                break;
            }
        }

        if (encontrado) {
            guardar(this.medicos, listaMedicos); // Actualizamos archivo médicos
            System.out.println("   -> Médico eliminado del sistema.");

            // 2. Eliminamos sus consultas asociadas
            ArrayList<Consulta> listaConsultas = leerConsultas();
            // Usamos removeIf (forma moderna y segura de borrar en listas)
            // "Borrar la consulta C si el ID de la consulta es igual al ID eliminado"
            final int finalId = idEliminar;
            boolean borroConsultas = listaConsultas.removeIf(c -> c.getIdMed() == finalId);

            guardar(this.consultas, listaConsultas); // Actualizamos archivo consultas

            if(borroConsultas) System.out.println("   -> Sus consultas también fueron eliminadas.");
            else System.out.println("   -> el medico no tiene consultas");

        } else {
            System.out.println("   -> No yay medicop.");
        }
    }

    // C: CAMBIAR DÍA (Navidad o Año Nuevo)

    public void cambiarFechasFestivas() {
        System.out.println("\n>>> VERIFICANDO FECHAS FESTIVAS NAVIDAD yAÑO NUEVO...");
        ArrayList<Consulta> lista = leerConsultas();
        int cont = 0;

        for (Consulta c : lista) {
            boolean esNavidad = (c.getDia() == 25 && c.getMes().equalsIgnoreCase("Diciembre"));
            boolean esAnioNuevo = (c.getDia() == 1 && c.getMes().equalsIgnoreCase("Enero"));

            if (esNavidad || esAnioNuevo) {
                // Lógica simple: Movemos la cita 2 días después
                c.setDia(c.getDia() + 2);
                cont++;
            }
        }

        if (cont > 0) {
            guardar(this.consultas, lista);
            System.out.println("   -> Se reprogramaron " + cont + " citas festivas.");
        } else {
            System.out.println("   -> No hay citas en fechas festivas.");
        }
    }
    // D: MOSTRAR CUMPLEAÑOS

    public void reporteCumpleanos(int dia, String mes) {
        System.out.println("\n>>> REPORTE DE CUMPLEAÑOS (" + dia + " de " + mes + ")");
        ArrayList<Consulta> lista = leerConsultas();
        for (Consulta c : lista) {
            if (c.getDia() == dia && c.getMes().equalsIgnoreCase(mes)) {
                System.out.println("   * ATENDIDO: " + c.toString());
            }
        }
    }

    // ver si funca
    public void listarTodo() {
        System.out.println("-------------------------------------------------");
        System.out.println("LISTA ACTUAL DE MEDICOS:");
        for(Medico m : leerMedicos()) System.out.println("   " + m);
        System.out.println("\nLISTA ACTUAL DE CONSULTAS:");
        for(Consulta c : leerConsultas()) System.out.println("   " + c);
        System.out.println("-------------------------------------------------");
    }
}