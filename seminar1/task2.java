import java.util.Scanner;

public class task2 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double x = scanner.nextDouble();

        double answer = getAnswer(x);

        System.out.println(answer);

    };

    public static double getAnswer(double number){
        return Math.acos(number) + Math.asin(2 * number) + Math.atan(3 * number);
    };
}
