package homework3;

import java.util.Arrays;

public class task3 {
    public static void main(String[] args){
        int[] ages1 = new int[]{18, 65, 4, 65, 32};
        int[] ages2 = new int[]{0, 120, 7, 7};

        System.out.println(Arrays.toString(counterSort(ages1)));
        System.out.println(Arrays.toString(counterSort(ages2)));

    }
    // Временная сложность: O(n)
    // Пространственная сложность: O(n)
    public static int[] counterSort(int[] numbers){
        // Память O(1)
        int[] counter = new int[121]; // От 0 до 120 (включительно)

        // Сложность O(n)
        for (int i = 0; i < numbers.length; i++){
            counter[numbers[i]]++;
        }

        // Память O(n) + O(1) = O(n)
        int[] answer = new int[numbers.length];
        int pos = 0;

        // Сложность O(n)
        for (int i = 0; i < numbers.length; i++){
            while (counter[pos] < 1){
                pos++;
            }
            answer[i] = pos;
            counter[pos]--;
        }
        return answer;
    }
}
