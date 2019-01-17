package Leetcode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by apple on 1/5/19.
 */
public class kSubsequences {
    public static int findSubsequences(int[] data, int k) {
        int[] sum = new int[data.length];
        int value = 0;
        // prefix sum
        for (int i = 0; i < data.length; i++) {
            value += data[i];
            sum[i] = value;
            System.out.print(sum[i]);
        }
        System.out.println("");
        // check
        int[] bucket = new int[k];
        for (int i = 0; i < data.length; i++) {
            bucket[sum[i]%k]++;
        }

        // count;
        int res = bucket[0];
        for (int i = 0; i < bucket.length; i++) {
            System.out.print(bucket[i]);
            if (bucket[i] > 1){
                res += (bucket[i] * (bucket[i] - 1))/2;
            }
        }
        System.out.println(" ");
        return res;
    }

    public static long findthat(long[] data, int k) {
        long[] sum = new long[data.length];
        Arrays.fill(sum, 0);
        long value = 0;
        sum[0] = data[0];
        // prefix sum
        for (int p = 1; p < data.length; p++) {
            sum[p] = sum[p - 1] + data[p];
            //System.out.print(sum[i]);
        }
        //System.out.println("");
        // check
        long[] bucket = new long[k];
        Arrays.fill(bucket, 0);
        int remain;
        for (int p = 0; p < data.length; p++) {
            remain =  (int)(sum[p]%(long)k);
            System.out.println(remain + " " + sum[p]);
            bucket[remain]++;
        }

        // count;
        long res = bucket[0];
        for (int p = 0; p < bucket.length; p++) {
            //System.out.print(bucket[i]);
            if (bucket[p] > 1){
                res += (bucket[p] * (bucket[p] - 1))/2;
            }
        }
        //System.out.println(" ");
        return res;
    }

//    public static void main(String[] args) {
////        Scanner sc = new Scanner(System.in);
////        int size = sc.nextInt();
////
////        for (int i = 0; i < size; i++) {
////            int n = sc.nextInt();
////            int k = sc.nextInt();
////            long[] numbers = new long[n];
////
////            for(int j = 0; j < n; j++)
////            {
////                numbers[j] = sc.nextLong();
////            }
////
////            System.out.println(findthat(numbers, k));
////        }
//        kSubsequences k1 = new kSubsequences();
//        int[] data1 = new int[]{1,2, 3, 4, 1};
//        System.out.println(k1.findSubsequences(data1, 3));
//        int[] data2 = new int[]{1, 2, 1, 2, 1, 2};
//        System.out.println(k1.findSubsequences(data2, 2));
//    }


    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc;
        try {
            //读取项目中的文
            sc = new Scanner(new File("/Users/apple/IdeaProjects/algorithms/src/Leetcode/input.txt"));
            int count = 0;
            int caseNum = sc.nextInt();
            System.out.println(caseNum);
            //通过判断是否有下一行来输出文档内容

            for (int i = 0; i < caseNum; i++) {
                int n = sc.nextInt();
                int k = sc.nextInt();
                long[] numbers = new long[n];
                System.out.println("n:" + n + " k:" + k);
                for(int j = 0; j < n; j++)
                {
                    if (sc.hasNextLong()){
                        numbers[j] = sc.nextLong();
                    }
                }
                count++;

                System.out.println(findthat(numbers, k) + " " + count);
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
}
