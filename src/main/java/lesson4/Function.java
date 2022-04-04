package lesson4;

public class Function {

    public static double getAreaOfTriangle(double a, double b, double c) throws NotTriangleExeption {

        if (a <= 0 || b <= 0 || c <= 0) {
            throw new IllegalArgumentException();
        }

        if (a > b + c || b > a + c || c > b + a) {
            throw new NotTriangleExeption();
        }

        double p = (a + b + c) / 2;
        return Math.sqrt(p * (p - a) * (p - b) * (p - c));
    }
}
