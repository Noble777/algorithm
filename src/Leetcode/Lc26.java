package Leetcode;

/**
 * Created by apple on 18/9/26.
 */
public class Lc26 {
    public int removeDuplicate(int[] nums) {
        int len = nums.length;
        // check
        if (len == 0 || len == 1) {
            return len;
        }

        int slow = 0;
        int fast = 1;
        int count = 1;
        while (slow < len && fast < len) {
            //System.out.println(fast + " " + slow);
            if (nums[slow] == nums[fast]) {
                fast++;
            }
            else {
                //System.out.println("AAAA");
                slow = fast;
                count++;
                fast++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Lc26 test = new Lc26();
        int[] nums = new int[] {1,1,1,1,2,3,3};
        System.out.println(test.removeDuplicate(nums));

    }

    // 1 1 2
       //  s f
}
