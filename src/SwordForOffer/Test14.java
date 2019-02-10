package SwordForOffer;

/**
 * 长度为n的绳子，把绳子剪成m段，问m段长度的最大乘积是多少。m>1, n>1
 */
public class Test14 {
    // time O(n^2), space O(n)
    public static int findMax(int n) {
        if (n  < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        int temp = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i/2; j++) {
                temp = dp[j] * dp[i-j];
                max = Math.max(temp, max);
            }
            dp[i] = max;
        }

        return dp[n];
    }

    // time O(n), space O(1)
    public static int findMax2(int n) {
        if (n  < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int timeOf3 = n/3;
        if (n - timeOf3 * 3 == 1) {
            timeOf3--;
        }
        int timeOf2 = (n - timeOf3 * 3)/2;
        return (int)(Math.pow(3, timeOf3)) * (int)(Math.pow(2, timeOf2));
    }

    public static void main(String[] args){
        for(int i=2;i<10;i++){
            System.out.println("长度为"+i+"的最大值->"+findMax2(i));
        }
    }
}
