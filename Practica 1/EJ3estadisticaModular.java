package EJERCICIOS;
import java.util.Scanner;

public class EJ3estadisticaModular {
//---------------------------------------------------
//						Calcula el promedio
    static double promedio(double[] xs) {
        double s = 0.0;
        for (int i = 0; i < xs.length; i++) s += xs[i];
        return s / xs.length;
    }
//---------------------------------------------------
//						Calcula la desviación
    static double desviacion(double[] xs) {
        double prom = promedio(xs);
        double acum = 0.0;
        for (int i = 0; i < xs.length; i++) {
            double d = xs[i] - prom;
            acum += d * d;
        }
        return Math.sqrt(acum / (xs.length - 1));
    }
//--------------------------------------------------------
//
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double[] xs = new double[10];
        for (int i = 0; i < 10; i++) xs[i] = sc.nextDouble();

        double prom = promedio(xs);
        double desv = desviacion(xs);

        System.out.printf("El promedio es %.2f%n", prom);
        System.out.printf("La desviación estandard es %.5f%n", desv);
        sc.close();
    }
}