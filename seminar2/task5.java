package homework2;

import java.util.Scanner;


public class task5 {
    public static void main(String[] args){
        // f(x) = sin(x) | sin(0) = 0
        // f'(x) = cos(x) | cos(0) = 1
        // f''(x) = -sin(x) | -sin(0) = 0
        // f'''(x) = -cos(x) | -cos(0) = -1
        // f^(4)(x) = sin(x) | sin(0) = 0

        // Sum^{\inf}_{i = 0}{f^{(i)}(0) / i! * x^i}

        // System.out.println("Привет, это программа считает синус через ряд Маклорена");
        // System.out.print("Введи число в радианах и узнай ответ: ");

        Scanner scanner = new Scanner(System.in);
        int answer = 0;

        while (answer != 4){
            System.out.println("Сейчас ты находишься в меню");
            System.out.println("Нажми 1, чтобы начать расчёт");
            System.out.println("Нажми 2, чтобы узнать о программе");
            System.out.println("Нажми 3, чтобы узнать о разработчике");
            System.out.println("Нажми 4, чтобы выйти");
            System.out.print("Ответ: ");

            if (scanner.hasNextInt()){
                answer = scanner.nextInt();
            } else {
                System.out.println("Ошибка! Неподходящее значение");
            }
;

            if (answer == 1){
                System.out.print("Введи число в радианах и узнай ответ: ");

                while (!scanner.hasNextDouble()){
                    scanner.nextLine();
                    System.out.print("Ошибка! нужно число: ");
                }

                double number = scanner.nextDouble();
                double answer_sin = sin(number, 15);

                System.out.print("Ответ: ");
                System.out.println(answer_sin);

                System.out.print("Разница в точности с синусом из Math (java) : ");
                System.out.println(Math.abs(Math.sin(number) - answer_sin));
                System.out.println();

            }

            if (answer == 2){
                System.out.println("Привет, это программа считает синус через ряд Маклорена");
                System.out.println();
            }

            if (answer == 3){
                System.out.println("Узнать об авторе ты сможешь по ссылке: https://github.com/RATARETO");
                System.out.println();
            }
        }
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