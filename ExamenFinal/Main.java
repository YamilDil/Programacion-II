package examen;
import java.io.File;

public class Main {
    public static void main(String[] args) {
        // Limpieza previa: borramos archivos viejos para empezar limpios
        new File("medicos.dat").delete();
        new File("consultas.dat").delete();

        Consultorio sistema = new Consultorio();

        // INCISO A: DAR DE ALTA (3 Médicos, 9 Consultas)
        System.out.println("DANDO DE ALTA...");

        // Médicos
        sistema.altaMedico(new Medico(1, "Juan", "Perez", 10));
        sistema.altaMedico(new Medico(2, "Jhony", "Felipez", 5)); // Este será borrado
        sistema.altaMedico(new Medico(3, "Auxi", "Uno", 12));

        // Consultas
        // Citas normales
        sistema.altaConsulta(new Consulta(101, "Pepe", "Uno", 1, 10, "Octubre", 2025));
        sistema.altaConsulta(new Consulta(102, "Pepe", "Dos", 3, 12, "Noviembre", 2025));

        // Citas del médico Auxi 1 ui2 Deben borrarse en el inciso B
        sistema.altaConsulta(new Consulta(103, "Pepe", "Tres", 2, 14, "Agosto", 2025));
        sistema.altaConsulta(new Consulta(104, "Pepe", "Cuatro", 2, 15, "Agosto", 2025));

        // Citas en FESTIVOS -> Deben cambiar fecha en inciso C
        sistema.altaConsulta(new Consulta(105, "Pepe", "Cinco", 1, 25, "Diciembre", 2025)); // Navidad
        sistema.altaConsulta(new Consulta(106, "Pepe", "Seis", 3, 25, "Diciembre", 2025)); // Navidad
        sistema.altaConsulta(new Consulta(107, "Pepe", "Siete", 1, 1, "Enero", 2026)); // Año Nuevo

        // Citas en mi CUMPLEAÑOS, Inciso D
        // Agregamos dos pacientes para que aparezcan en tu reporte
        sistema.altaConsulta(new Consulta(108, "Pepe", "Ocho", 3, 7, "Junio", 2025));
        sistema.altaConsulta(new Consulta(109, "Pepe", "Nueve", 1, 7, "Junio", 2025));

        sistema.listarTodo(); // VEMOS ESTADO INICIAL

        // B: BAJA DE MEDICO

        sistema.bajaMedico("Jhony", "Felipez");

        // C: CAMBIAR FECHAS FESTIVAS

        sistema.cambiarFechasFestivas();

        // D: CUMPLEAÑOS

        sistema.reporteCumpleanos(7, "Junio");

    }
}