package SwordForOffer;

public class Test15 {
    // 负数会引起死循环， 因为负数往右移动一位，第一位会补上一个1
    public static int countOne(int n) {
        int count = 0;
        while (n != 0) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }

    public static int countOne2(int n) {
        int count = 0;
        int mask = 1;
        while (mask != 0) {
            if ((mask & n) != 0) {
                count++;
            }
            mask = mask << 1;
        }
        return count;
    }


    //把一个整数减去1之后再和原来的整数做位与运算，得到的结果相当于把原整数的二进制表示形式的最右边的1变成0
    //所以能运行几次，就有几个1。
    public static int countOne3(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n -1);
            count++;
        }
        return count;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " has " + countOne3(i) + " times 1.");
        }

        System.out.println(-1 + "has " + countOne3(-1) + " times 1.");

    }
}
