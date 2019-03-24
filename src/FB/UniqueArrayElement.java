package FB;

import java.util.Arrays;
import java.util.HashSet;

/*
  Given an unsorted array of integers, all the elements are duplicated except one element,
  find the unique array element
 */
public class UniqueArrayElement {
    // sorted O(nlogn)
    public static int findUniqueElement1(int[] arr) {
        // sorted
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i = i + 2) {
            if (arr[i] != arr[i+1]) {
                return arr[i];
            }
        }
        return -1;
    }

    // hashset T & S: O(n)
    public static int findUniqueElement2(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int element : arr) {
            if (set.contains(element)) {
                set.remove(element);
            }
            else {
                set.add(element);
            }
        }

        for (Integer one : set) {
            return one;
        }
        return -1;
    }

    // bit T: O(N), S:O(1)
    public static int findUniqueElement3(int[] arr) {
        int res = 0;
        for (int element : arr) {
            // XOR
            res ^= element;
        }
        return res > 0 ? res : -1;
    }


    public static void main(String[] args) {
        int[] arr = {1, 3, 3, 2, 4, 5, 6, 5, 6, 1, 2};
        System.out.println(findUniqueElement3(arr));
    }
}
