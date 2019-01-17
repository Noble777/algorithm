package SwordForOffer;

/**
 * Created by apple on 1/9/19.
 * fibonacci
 */
public class Test10 {

    //定义递归， time O(n^2)
    public static int fibonacci1(int n) {
        if (n == 0) {
            return 0;
        }
        else if (n == 1) {
            return 1;
        }
        return fibonacci1(n - 1) + fibonacci1(n - 2);
    }

    // 有重复状态, time O(n)
    public static int fibonacci2(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    //只需要记住前两个数就够了。time O(n)
    public static int fibonacci3(int n) {
        int temp1 = 0;
        int temp2 = 1;
        int res = 0;
        if (n == 0) {
            return temp1;
        }
        else if (n == 1) {
            return temp2;
        }

        for (int i = 2; i <= n; i++) {
            res = temp1 + temp2;
            temp1 = temp2;
            temp2 = res;
        }

        return res;
    }


    // 借助如下数学公式解决问题。矩阵乘法部分，可用递归解决，时间复杂度o(logn)
    // [ f(n)  f(n-1) ] = [ 1  1 ] ^ n-1   (当n>2)
    // [f(n-1) f(n-2) ]   [ 1  0 ]
    // 证明:
    // [ f(n)  f(n-1) ] = [ f(n-1)+f(n-2)  f(n-1)] = [ f(n-1)  f(n-2)] * [1 1]
    // [f(n-1) f(n-2) ]   [ f(n-2)+f(n-3)  f(n-2)]   [ f(n-2)  f(n-3)]   [1 0]
    // 得到如上递推式，所以
    // [ f(n)  f(n-1) ] = [ f(2)  f(1)] * [1 1]^n-2 = [1 1]^n-1
    // [f(n-1) f(n-2) ]   [ f(1)  f(0)]   [1 0]       [1 0]

    public static int fibonacci4(int n) {
        int[][] start = {{1,1},{1,0}};
        return matrixPow(start,n-1)[0][0];
    }

    public static int[][] matrixPow(int[][] start,int n){
        if((n&1)==0){
            int[][] temp = matrixPow(start,n>>1);
            return matrixMultiply(temp,temp);
        }
        else if(n==1){
            return start;
        }
        else{
            return matrixMultiply(start,matrixPow(start,n-1));
        }
    }
    public static int[][] matrixMultiply(int[][] x,int[][] y){
        int[][] result = new int[x.length][y[0].length];
        for(int i=0;i<x.length;i++){
            for(int j=0;j<y[0].length;j++){
                int sum = 0;
                for(int k=0;k<x[0].length;k++){
                    sum += x[i][k]*y[k][j];
                }
                result[i][j] = sum;
            }
        }
        return result;
    }

    // 使用通项公式完成，时间复杂度o(1)
    // f(n) = (1/√5)*{[(1+√5)/2]^n - [(1-√5)/2]^n}
    // 推导过程可参考https://wenku.baidu.com/view/57333fe36bd97f192379e936.html
    public static int fibonacci5(int n){
        double gen5 = Math.sqrt(5);
        return (int)((1/gen5)*(Math.pow((1+gen5)/2,n)- Math.pow((1-gen5)/2,n)));
    }


    public static void main(String[] args) {
        System.out.println(fibonacci1(3));
        System.out.println(fibonacci2(3));
        System.out.println(fibonacci3(3));
        System.out.println(fibonacci4(3));
        System.out.println(fibonacci5(3));
    }
}
