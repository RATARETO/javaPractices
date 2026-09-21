import java.util.Scanner;


public class task4 {
    public static void main(String[] args){
        // f(x) = sin(x) | sin(0) = 0
        // f'(x) = cos(x) | cos(0) = 1
        // f''(x) = -sin(x) | -sin(0) = 0
        // f'''(x) = -cos(x) | -cos(0) = -1
        // f^(4)(x) = sin(x) | sin(0) = 0

        // Sum^{\inf}_{i = 0}{f^{(i)}(0) / i! * x^i}

        System.out.println("Привет, это программа считает синус через ряд Маклорена");
        System.out.print("Введи число в радианах и узнай ответ: ");

        Scanner scanner = new Scanner(System.in);

        // Валидация
        if (!scanner.hasNextDouble()){
            System.out.println("Ошибка нужно число");
        }

        double number = scanner.nextDouble();
        double answer = sin(number, 15);

        System.out.print("Ответ: ");
        System.out.println(answer);

        System.out.print("Разница в точности с синусом из Math (java) : ");
        System.out.println(Math.abs(Math.sin(number) - answer));

    }

    public static double sin(double number, int accuracy){
        int [] derivatives = {0, 1, 0, -1};

        double sum = 0.0;

        double factorial = 1;
        for (int i = 0; i <= accuracy; i++){
            if (i >= 1){
                factorial *= i;
            }

            int derivative = derivatives[i % 4];
            sum += derivative / factorial * Math.pow(number, i);

        }

        return sum;
    }
}
