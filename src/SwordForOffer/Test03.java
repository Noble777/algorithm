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

    public static void exch(int[] data, int i, int j) {
        int temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }
    public static void quickSort(int[] data, int start, int end) {
        if (start >= end) {
            return;
        }
        int p = partition(data, start, end);
        quickSort(data, start, p - 1);
        quickSort(data, p + 1, end);
    }

    public static int partition(int[] data, int start, int end) {
        int i = start, j = end + 1;
        int pivot = data[i];
        while (true) {
            while (data[++i] < pivot) {
                if (i == end) break;
            }
            while (data[--j] > pivot) {
                if (j == start) break;
            }
            if (i >= j) {
                break;
            }
            exch(data, i, j);
        }
        exch(data, start, j);
        return j;
    }

    // version3: hashTable, 不会改变原数据， 时间O(n)， 空间O(n)
    public static int getDuplication3(int[] data) {
        if (data == null || data.length < 2) {
            return -1;
        }
        int[] hashTable = new int[data.length];

        for (int item : data) {
            if (hashTable[item] >= 1) {
                return item;
            }
            else {
                hashTable[item] ++;
            }
        }
        return -1;
    }

    // version4: 归位法, 会改变原数据， 时间O(n)， 空间O(1)
    // 0 1 2 ... n-1
    public static int getDuplication4(int[] data) {
        if (data == null || data.length < 2) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            // data[i] != data[data[i]]而不是i != data[i]，避免了死循环，因为我要换的那个地方可能是已经排好的数，就不需要换了
            while(data[i] < data.length && data[i] >= 0 && data[i] != data[data[i]]) {
                if (data[i] == data[data[i]]) {
                    break;
                }
                exch(data, i, data[i]);
            }
        }

        for (int i = 0; i < data.length; i++) {
            if (i != data[i]) {
                return data[i];
            }
        }
        return -1;
    }


    // version5: 标记法, 会改变原数据， 时间O(n)， 空间O(1)
    // 0 1 2 ... n-1
    public static int getDuplication5(int[] data) {
        if (data == null || data.length < 2) {
            return -1;
        }

        for (int i = 0; i < data.length; i++) {
            int idx = Math.abs(data[i]);
            if (data[idx] < 0) {
                return idx;
            }
            data[idx] = -data[idx];
        }

        for (int i = 0; i < data.length; i++) {
            if (i != data[i]) {
                return data[i];
            }
        }
        return -1;
    }

    public static void main(String[] args){
        int[] data = {2,3,2,0,1,5,3};
        System.out.println(getDuplication(data));
        System.out.println(getDuplication2(data));
        System.out.println(getDuplication3(data));
        System.out.println(getDuplication4(data));
        System.out.println(getDuplication5(data));

        int[] data1 = {2,3,1,0,4,5,5};
        System.out.println(getDuplication(data1));
        System.out.println(getDuplication2(data1));
        System.out.println(getDuplication3(data1));
        System.out.println(getDuplication4(data1));
        System.out.println(getDuplication5(data1));
    }

}
