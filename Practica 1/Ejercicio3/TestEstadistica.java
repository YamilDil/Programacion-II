import java.util.Scanner;

class Estadistica {
    private double[] datos;

    public Estadistica(double[] datos) {
        this.datos = datos;
    }

    public double promedio() {
        double s = 0.0;
        for (int i = 0; i < datos.length; i++) s += datos[i];
        return s / datos.length;
    }

    public double desviacion() {
        double prom = promedio();
        double acum = 0.0;
        for (int i = 0; i < datos.length; i++) {
            double d = datos[i] - prom;
            acum += d * d;
        }
        return Math.sqrt(acum / (datos.length - 1));
    }
}

public class TestEstadistica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] xs = new double[10];
        for (int i = 0; i < 10; i++) xs[i] = sc.nextDouble();

        Estadistica est = new Estadistica(xs);
        double prom = est.promedio();
        double desv = est.desviacion();

        System.out.printf("El promedio es %.2f%n", prom);
        System.out.printf("La desviación estandard es %.5f%n", desv);
        sc.close();
    }
}
