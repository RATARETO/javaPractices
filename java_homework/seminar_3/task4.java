package javahomework3;

public class task4 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,  2,  3,  4},
                {5,  6,  7,  8},
                {9,  10, 11, 12},
                {13, 14, 15, 16}
        };

        printByCorners(matrix);
    }

    public static void printByCorners(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return;
        }
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;

        while (top <= bottom && left <= right) {

            for (int i = top; i <= bottom; i++) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;

            if (left > right || top > bottom) break;

            for (int j = left; j <= right; j++) {
                System.out.print(matrix[bottom][j] + " ");
            }
            bottom--;

            if (left > right || top > bottom) break;

            for (int i = bottom; i >= top; i--) {
                System.out.print(matrix[i][left] + " ");
            }
            left++;

            if (left > right || top > bottom) break;

            for (int j = right; j >= left; j--) {
                System.out.print(matrix[bottom][j] + " ");
            }
            bottom--;
        }
        System.out.println();
    }
}