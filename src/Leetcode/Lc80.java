package Leetcode;

/**
 * Created by apple on 18/9/26.
 */
public class Lc80 {
    public int removeDuplicates(int[] nums) {
        // check
        if (nums.length == 0) {
            return 0;
        }

        int count = 1;
        int len = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] == nums[i]) {
                if (count >= 2) {
                    System.out.println(i);
                    len--;
                }
                count++;

            }
            else {
                count = 1;
            }
            //System.out.println(i);
            len++;
        }
        return len + 1;
    }

    public static void main(String[] args) {
        Lc80 test = new Lc80();
        int[] nums = new int[] {1,1,1,1,1,2,3,3,3};
        System.out.println(test.removeDuplicates(nums));

    }
}

