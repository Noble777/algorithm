package SwordForOffer;

/**
 * Created by apple on 12/20/18.
 */
public class Test03 {
    // 1. 暴力解，不改变数据，时间O(n^2), 空间O(1)
    public static int getDuplication(int[] data) {
        if (data == null || data.length < 2) {
            return -1;
        }
        for (int i = 0; i < data.length - 1; i++) {
            for (int j = i + 1; j < data.length; j++) {
                if (data[i] == data[j]) {
                    return data[i];
                }
            }
        }

        return -1;
    }

    // 2.排序，会改变原数据，时间O(nlogn), 空间O(1)
    public static int getDuplication2(int[] data) {
        if(data == null || data.length < 2) {
            return -1;
        }

        // 内置的sort函数
        // Arrays.sort(data)
        quickSort(data, 0, data.length - 1);
        int prev = data[0];
        for (int i = 1; i < data.length; i++) {
            if (data[i] == prev) {
                return prev;
            }
            else {
                prev = data[i];
            }
        }
        return -1;
    }

    public static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        
    }

    public static void main(String[] args) {

    }
}
