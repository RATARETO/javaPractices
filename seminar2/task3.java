package homework2;

public class task3 {
    public static void main(String[] args){
        // N = n_{1} * 1 + n_{2} * 10 + ... + n_{k - 1} * 10^{k - 1} Что имеем
        // M = n_{k - 1} * 1 + n_{k - 2} * 10 + ... + n_{1} * 10^{k - 1} Что получем

        long myNumber = getNumber(123456789);
        System.out.println(myNumber);

    }

    public static long getNumber(long number){
        long answer = 0;

        while (number != 0){
            answer = answer * 10 + (number % 10);
            number /= 10;

        }
        return answer;
    }
}
