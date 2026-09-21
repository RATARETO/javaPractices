import java.util.Scanner;

public class task3 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        double number1 = scanner.nextDouble();
        double number2 = scanner.nextDouble();

        if (number1 > number2){
            System.out.println(number1);
        } else {
            System.out.println(number2);
        }
    }
}
