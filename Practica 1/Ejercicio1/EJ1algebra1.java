package EJERCICIOS;
import java.util.Scanner;
//-------------------------------------------------------------------
//						CLASE
class EcuacionLineal {
//------------------------------------------------------------------
//						ATRIBUTOS
    private double a, b, c, d, e, f;
//-------------------------------------------------------------------
//						METODOS
    public EcuacionLineal(double a, double b, double c, double d, double e, double f) {
        this.a = a; this.b = b; this.c = c;
        this.d = d; this.e = e; this.f = f; // constructor
    }

    public boolean tieneSolucion() {
        return (a * d - b * c) != 0.0;
    }

    public double getX() {
        double den = a * d - b * c;
        return (e * d - b * f) / den;
    }

    public double getY() {
        double den = a * d - b * c;
        return (a * f - e * c) / den;
    }
}
//-----------------------------------------------------------------------
public class EJ1algebra1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Ingrese a, b, c, d, e, f: ");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();
        double d = sc.nextDouble();
        double e = sc.nextDouble();
        double f = sc.nextDouble();

        EcuacionLineal eq = new EcuacionLineal(a, b, c, d, e, f);// inicializamos el constructor

        if (!eq.tieneSolucion()) {
            System.out.println("La ecuación no tiene solución");
        } else {
            System.out.println("x = " + eq.getX() + ", y = " + eq.getY());
        }
        sc.close();
    }
}
