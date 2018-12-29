package SwordForOffer;

/**
 * Created by apple on 12/26/18.
 */
public class Test04 {
    // solution 1: O(M + N)
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

    // solution 2: binary search O(logN + logM)
    // need another condition: The first integer of each row is greater than the last integer of the previous row.
    // so the case 1 can be a good example
    public static boolean findSortedMatrix2(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start < end) {
            int mid = start + (end - start)/2;
            int midVal = matrix[mid/col][mid%col];
            if (midVal == target) {
                return true;
            }
            else if (midVal < target) {
                start = mid + 1;
            }
            else{
                end = mid;
            }
        }
        return matrix[start/col][start%col] == target;
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
        System.out.println("__________________");
        System.out.println(findSortedMatrix2(data, 10));
        System.out.println(findSortedMatrix2(data, 5));
        System.out.println(findSortedMatrix2(data1, 1));
        System.out.println(findSortedMatrix2(data1, 0));
        System.out.println(findSortedMatrix2(data2, 0));
    }
}

