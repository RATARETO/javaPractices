package javahomework3;

import java.util.Arrays;

public class task1 {
    public static void main(String[] args){
        int number = 20;
        long[] numbers = new long[20];

        for (int i = 0; i < number; i ++){
            numbers[i] = getFibonacci(i + 1);
        }

        System.out.println(Arrays.toString(numbers));
    }

    public static long getFibonacci(long N){
        if (N <= 2){
            return 1;
        }
        return getFibonacci(N - 1) + getFibonacci(N  - 2);
    }
}
