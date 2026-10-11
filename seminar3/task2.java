package homework3;

import java.util.Arrays;

public class task2 {
    public static void main(String[] args) {
        int[] times1 = {1200, 15, 600, 75};
        int[] times2 = {99999, 100000, 1};

        System.out.println(Arrays.toString(radixSort(times1)));
        System.out.println(Arrays.toString(radixSort(times2)));
    }

    // Временная сложность: O(n)
    // Пространственная сложность: O(n)
    public static int[] radixSort(int[] numbers) {
        if (numbers.length == 0) return numbers;

        int max = numbers[0];
        for (int num : numbers) {
            if (num > max) max = num;
        }

        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSortByDigit(numbers, exp);
        }
        return numbers;
    }

    private static void countingSortByDigit(int[] numbers, int exp) {
        int n = numbers.length;
        int[] output = new int[n];
        int[] count = new int[10];

        for (int i = 0; i < n; i++) {
            count[(numbers[i] / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            count[i] += count[i - 1];
        }

        for (int i = n - 1; i >= 0; i--) {
            int digit = (numbers[i] / exp) % 10;
            output[count[digit] - 1] = numbers[i];
            count[digit]--;
        }
        
        System.arraycopy(output, 0, numbers, 0, n);
    }
}