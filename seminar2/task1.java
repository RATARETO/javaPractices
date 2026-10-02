package homework2;

public class task1 {
    public static void main(String[] args){
        getSinTable();
    }

    public static void getSinTable(){
        int left = 90;

        for (int x = 0; x < left; x += 5){
            System.out.println(String.format("value: %2d | sin: %.4f", x, Math.sin(Math.toRadians(x))));
        }
    }
}
