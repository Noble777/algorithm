package SwordForOffer;

/**
 * Created by apple on 12/26/18.
 */
public class Test04 {
    public static boolean findSortedMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int r = row - 1;
        int c = 0;
        while (bound(r, c, row, col)) {

            if (matrix[r][c] < target) {
                c++;
            }
            else if (matrix[r][c] > target) {
                r--;
            }
            else {
                return true;
            }
        }
        return false;
    }

    public static boolean bound(int r, int c, int row, int col) {
        if (r < 0 || c < 0 || r > row - 1|| c > col - 1) {
            return false;
        }
        return true;
    }

    public static void main(String[] args){
        int[][] data = {{1,2,8,9},
                        {2,4,9,12},
                        {4,7,10,13},
                        {6,8,11,15}};
        int[][] data1 = {{1}};
        int[][] data2 = {{}};
        System.out.println(findSortedMatrix(data, 10));
        System.out.println(findSortedMatrix(data, 5));
        System.out.println(findSortedMatrix(data1, 1));
        System.out.println(findSortedMatrix(data1, 0));
        System.out.println(findSortedMatrix(data2, 0));
    }
}

