package javahomework3;

public class task2 {
    public static void main(String[] args){
        // long[] myNumbers = {1, 2, 3, 4, 5, 1, 2, 3, 1, 2, 3, 4, 5, 6};
        int[] myNumbers = {1, 9, 3, 4, 5, 1, 2, 3, 1, 2, 3, 4, 5, 6};
        System.out.println(get_answer(myNumbers));
    }

    public static int get_answer(int[] numbers) {
        if (numbers == null || numbers.length < 2) {
            return 0;
        }

        int count = 0;
        boolean inSegment = false;

        for (int i = 0; i < numbers.length - 1; i++) {
            if (numbers[i + 1] > numbers[i]) {
                if (!inSegment) {

                    count++;
                    inSegment = true;
                }
            } else {
                inSegment = false;
            }
        }
        return count;
    }
}
