package SwordForOffer;

public class Test13 {
    public static int movingCount(int threshold, int rowLen, int colLen) {
        if (rowLen <= 0 || colLen <= 0 || threshold < 0) {
            return 0;
        }
        boolean[][] visited = new boolean[rowLen][colLen];

        return movingCountHelper(threshold, rowLen, colLen, 0, 0, visited);
    }

    public static int movingCountHelper(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visited) {
        int count = 0;
        if (canGetin(threshold, rowLen, colLen, row, col, visited)) {
            visited[row][col] = true;
            count = 1 + movingCountHelper(threshold, rowLen, colLen, row + 1, col, visited)
                    + movingCountHelper(threshold, rowLen, colLen, row - 1, col, visited)
                    + movingCountHelper(threshold, rowLen, colLen, row, col + 1, visited)
                    + movingCountHelper(threshold, rowLen, colLen, row, col - 1, visited);
        }
        return count;
    }

    public static boolean canGetin(int threshold, int rowLen, int colLen, int row, int col, boolean[][] visited) {
        return row >= 0 && col >= 0 && row < rowLen && col < colLen && !visited[row][col]
                && gitDigitalSum(row) + gitDigitalSum(col) <= threshold;
    }

    public static int gitDigitalSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num = num/10;
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(movingCount(0,3,4)); //1
        System.out.println(movingCount(1,3,4)); //3
        System.out.println(movingCount(9,2,20)); //36
    }
}
