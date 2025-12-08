package examen;

import java.io.Serializable;

public class Consulta implements Serializable {

    private int ci;
    private String nombrePaciente;
    private String apellidoPaciente;
    private int idMed; // Relación con el médico
    private int dia;
    private String mes;
    private int anio;

    // CONSTRUCTOR
    public Consulta(int ci, String nombrePaciente, String apellidoPaciente, int idMed, int dia, String mes, int anio) {
        this.ci = ci;
        this.nombrePaciente = nombrePaciente;
        this.apellidoPaciente = apellidoPaciente;
        this.idMed = idMed;
        this.dia = dia;
        this.mes = mes;
        this.anio = anio;
    }

    // GETTERS
    public int getIdMed() {
        return idMed;
    }

    public int getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    // SETTER PARA EL INCISO C (Cambiar el día)
    public void setDia(int dia) {
        this.dia = dia;
    }

    @Override
    public String toString() {
        return "Paciente: " + nombrePaciente + " " + apellidoPaciente + " | Fecha: " + dia + "/" + mes + "/" + anio + " | ID Medico: " + idMed;
    }
}