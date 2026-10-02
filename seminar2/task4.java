package homework2;

public class task4 {
    public static void main(String[] args){
        double number1 = 6767.67;
        double number2 = 6.7;

        getGeometricAndArithmeticMean(number1, number2);
    }

    public static void getGeometricAndArithmeticMean(double a, double b){
        double geometric = Math.sqrt(a * b);
        double arithmetic = (a + b) / 2;

        System.out.println(String.format("Geometric mean %.4f and %.4f: %.4f", a, b, geometric));
        System.out.println(String.format("Arithmetic mean %.4f and %.4f: %.4f", a, b, arithmetic));
    }
}
