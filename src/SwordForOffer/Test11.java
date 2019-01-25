package SwordForOffer;


/**
 * find smallest element in rotated array
 */
public class Test11 {
    public static int findSmallest(int[] arr) {
        if (arr == null || arr.length == 0) {
            return -1;
        }
        int left = 0;
        int right = arr.length - 1;
        int mid;
        while (left < right) {
            mid = left + (right - left)/2;
            if (arr[left] < arr[right]) {
                return arr[left];
            }
            else if (arr[left] > arr[right]) {
                if (arr[mid] < arr[right]) {
                    right = mid;
                }
                else {
                    left = mid + 1;
                }
            }
            else {
                right--;
            }
        }

        return arr[left];
    }


    public static void main(String[] args){
        int[] data1 = {3,4,5,1,2};
        int[] data2 = {1,0,1,1,1};
        int[] data3 = {1,1,1,0,1};
        System.out.println(findSmallest(data1));
        System.out.println(findSmallest(data2));
        System.out.println(findSmallest(data3));
    }

}
