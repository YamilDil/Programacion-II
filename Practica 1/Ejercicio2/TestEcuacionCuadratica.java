import java.util.Scanner;

class EcuacionCuadratica {
    private double a, b, c;

    public EcuacionCuadratica(double a, double b, double c) {
        this.a = a; 
        this.b = b; 
        this.c = c;
    }

    public double getDiscriminante() {
        return b * b - 4 * a * c;
    }

    public double getRaiz1() {
        double disc = getDiscriminante();
        if (disc < 0) return 0.0;
        return (-b + Math.sqrt(disc)) / (2 * a);
    }

    public double getRaiz2() {
        double disc = getDiscriminante();
        if (disc < 0) return 0.0;
        return (-b - Math.sqrt(disc)) / (2 * a);
    }

    public double getUnicaRaiz() {
        double disc = getDiscriminante();
        if (disc == 0) {
            return -b / (2 * a);
        }
        return 0.0;
    }
}

public class TestEcuacionCuadratica {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese a, b, c: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        EcuacionCuadratica eq = new EcuacionCuadratica(a, b, c);
        double disc = eq.getDiscriminante();

        if (disc > 0) {
            double r1 = eq.getRaiz1();
            double r2 = eq.getRaiz2();
            System.out.printf("La ecuación tiene dos raíces %.6f y %.6f%n", r1, r2);
        } else if (disc == 0) {
            double r = eq.getUnicaRaiz();
            System.out.println("La ecuación tiene una raíz " + ((r == -0.0) ? 0.0 : r));
        } else {
            System.out.println("La ecuación no tiene raíces reales");
        }
        sc.close();
    }
}
