package homework3;

import java.util.ArrayList;
import java.util.List;

public class task1 {
    public static void main(String[] args){
        double[] numbers1 = {0.25, 0.70, 0.10, 0.90};
        double[] numbers2 = {0.05, 0.05, 0.80};

        double[] sortedVotes1 = bucketSort(numbers1);

        for (double v : sortedVotes1) {
            System.out.print(v + " ");
        }

        System.out.println();

        double[] sortedVotes2 = bucketSort(numbers2);

        for (double v : sortedVotes2) {
            System.out.print(v + " ");
        }
    }
    // Временная сложность: O(n)
    // Пространственная сложность: O(n)
    public static double[] bucketSort(double[] numbers) {
        if (numbers.length == 0) return numbers;

        int numBuckets = 10;
        List<List<Double>> buckets = new ArrayList<>(numBuckets);
        for (int i = 0; i < numBuckets; i++) {
            buckets.add(new ArrayList<>());
        }

        for (double num : numbers) {
            int bucketIndex = (int) (num * numBuckets);
            if (bucketIndex == numBuckets) bucketIndex--;
            buckets.get(bucketIndex).add(num);
        }

        int index = 0;
        for (List<Double> bucket : buckets) {
            double[] bucketArray = new double[bucket.size()];
            for (int i = 0; i < bucket.size(); i++) {
                bucketArray[i] = bucket.get(i);
            }

            insertSort(bucketArray);

            for (double val : bucketArray) {
                numbers[index++] = val;
            }
        }
        return numbers;
    }
    // Временная сложность: O(n^{2}) при малых n - O(n)
    // Пространственная сложность: O(1)
    public static double[] insertSort(double[] numbers){
        for (int i = 0; i < numbers.length; i++){
            double value = numbers[i];
            int j  = i - 1;

            while (j >= 0 && numbers[j] > value){
                numbers[j + 1] = numbers[j];
                j--;
            }

            numbers[j + 1] = value;
        }
        return numbers;
    }
}
