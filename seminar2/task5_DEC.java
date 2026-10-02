package homework2;

import java.util.Scanner;

public class task5_DEC {

    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        boolean isRunning = true;

        while (isRunning) {
            printMenu();
            int choice = getMenuChoice();

            switch (choice) {
                case 1:
                    performCalculation();
                    break;
                case 2:
                    printProgramInfo();
                    break;
                case 3:
                    printDeveloperInfo();
                    break;
                case 4:
                    System.out.println("Выход из программы. До свидания!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Ошибка: неверный пункт меню. Попробуйте снова.\n");
            }
        }
        scanner.close();
    }

    // 1. Метод для вывода меню
    public static void printMenu() {
        System.out.println("========== МЕНЮ ==========");
        System.out.println("1. Выполнить расчёт");
        System.out.println("2. Информация о программе");
        System.out.println("3. Информация о разработчике");
        System.out.println("4. Выход");
        System.out.print("Выберите пункт: ");
    }


    public static int getMenuChoice() {
        while (!scanner.hasNextInt()) {
            System.out.print("Ошибка! Введите число от 1 до 4: ");
            scanner.nextLine();
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        return choice;
    }


    public static void performCalculation() {
        System.out.println("--- Расчёт синуса через ряд Маклорена ---");

        double number = 0;
        boolean validInput = false;

        while (!validInput) {
            System.out.print("Введи число в радианах (или 'q' для выхода в меню): ");
            if (scanner.hasNextDouble()) {
                number = scanner.nextDouble();
                validInput = true;
            } else {
                String input = scanner.nextLine();
                if (input.equalsIgnoreCase("q")) {
                    System.out.println("Возврат в главное меню...\n");
                    return; // Выход из метода расчета
                } else {
                    System.out.println("Ошибка! Нужно ввести число или 'q'.");
                }
            }
        }

        double answerSin = sin(number, 15);
        System.out.printf("Ответ: %.4f\n", answerSin);
        System.out.printf("Разница с Math.sin(): %.4f\n\n", Math.abs(Math.sin(number) - answerSin));
    }


    public static void printProgramInfo() {
        System.out.println("--- О программе ---");
        System.out.println("Эта программа вычисляет синус числа через разложение в ряд Маклорена.");
        System.out.println();
    }

    public static void printDeveloperInfo() {
        System.out.println("--- О разработчике ---");
        System.out.println("Автор: RATARETO");
        System.out.println("GitHub: https://github.com/RATARETO");
        System.out.println();
    }
    
    public static double sin(double number, int accuracy) {
        int[] derivatives = {0, 1, 0, -1};
        double sum = 0.0;
        double factorial = 1;

        for (int i = 0; i <= accuracy; i++) {
            if (i >= 1) {
                factorial *= i;
            }
            int derivative = derivatives[i % 4];
            sum += derivative / factorial * Math.pow(number, i);
        }
        return sum;
    }
}