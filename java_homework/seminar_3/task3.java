package javahomework3;

import java.util.Arrays;

public class task3 {
    public static void main(String[] args){
        double[] myNumbers = {1, 9, 3, 4, 5, 1, 2, 3, 1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(get_answer(myNumbers)));

    }

    public static double[] get_answer(double[] numbers){
        int length = numbers.length;

        double[] answer = new double[length];

        double currentSum = 0;
        for (double num : numbers) {
            currentSum += num;
        }

        for (int k = 0; k < length; k++) {
            int count = length - k;

            answer[k] = currentSum / count;

            currentSum -= numbers[k];
        }

        return answer;
    }
}
