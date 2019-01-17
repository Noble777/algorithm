package Leetcode;

import java.util.*;

/**
 * Created by apple on 1/5/19.
 */
public class DistinctPairs {
//    public static int DisPairs(int[] data, int target) {
//        List<List<Integer>> res1 = new ArrayList<>();
//        Arrays.sort(data);
//        int[] res = new int[1];
//        res[0] = 0;
//        backtrack(res1, res, new ArrayList<>(), data, target, 0);
//        System.out.println(res1);
//        return res[0];
//    }
//
//    public static void backtrack(List<List<Integer>> res1, int[] res, List<Integer> tempLst, int[] candidates, int remain, int start) {
//        if (remain < 0) {
//            return;
//        }
//        else if (remain == 0) {
//            res1.add(new ArrayList<>(tempLst));
//            res[0]++;
//        }
//        else {
//            for (int i = start; i < candidates.length; i++) {
//                if (i > start && candidates[i] == candidates[i - 1]) {
//                    continue;
//                }
//                tempLst.add(candidates[i]);
//                backtrack(res1, res, tempLst, candidates, remain - candidates[i], i + 1);;
//                tempLst.remove(tempLst.size() - 1);
//            }
//        }
//    }
    public static int DisPairs(int[] arr, int k) {
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(arr);
        for(int n : arr){
            if(n <= k && map.containsKey(k - n) && map.get(k - n) != n){
                map.put(k - n, n);
                //System.out.println(k - n + " " + n);
                count++;
            }
            else
                map.put(n, Integer.MAX_VALUE);

        }
        return count;
    }


    public static void main(String[] args) {
        DistinctPairs dp1 = new DistinctPairs();
        int[] data = new int[]{9, 1, 1, 9};
        int[] data2 = new int[]{1, 9, 9};
        System.out.println(dp1.DisPairs(data, 10));
        System.out.println(dp1.DisPairs(data2, 10));
    }
}
