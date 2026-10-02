package homework2;

public class task2 {
    public static void main(String[] args){
        double exp = getExp(10, 100);
        System.out.println(Math.abs(exp - Math.exp(10)));
    }

    public static double getExp(double x, long n){
        double factorial = 1.0;
        double answer = 0.0;

        for (long i = 0; i <= n; i++){
            if (i >= 2){
                factorial *= i;
            }
            answer += Math.pow(x, i) / factorial;
        }

        return answer;
    }
}
