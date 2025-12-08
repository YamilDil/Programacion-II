package examen;

import java.io.Serializable;

// Implementamos Serializable para poder guardar la clase en disco duro (persistencia)
public class Medico implements Serializable {

    // ATRIBUTOS (Estrictamente los del diagrama)
    private int idMed;
    private String nombreMed;
    private String apellidoMed;
    private int aniosExperiencia;

    // CONSTRUCTOR (Permitido agregar métodos)
    public Medico(int idMed, String nombreMed, String apellidoMed, int aniosExperiencia) {
        this.idMed = idMed;
        this.nombreMed = nombreMed;
        this.apellidoMed = apellidoMed;
        this.aniosExperiencia = aniosExperiencia;
    }

    // GETTERS (Para poder leer los datos privados)
    public int getIdMed() {
        return idMed;
    }

    public String getNombreMed() {
        return nombreMed;
    }

    public String getApellidoMed() {
        return apellidoMed;
    }

    // toString para imprimir bonito
    @Override
    public String toString() {
        return "ID: " + idMed + " | " + nombreMed + " " + apellidoMed + " (" + aniosExperiencia + " años exp)";
    }
}