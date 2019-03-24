package SwordForOffer;

import java.util.Arrays;

/**
 * Created by apple on 12/22/18.
 * REFER ALGORITHM BOOK
 */
public class Quicksort {
    public static void exch(Object[] a, int i, int j) {
        Object temp  = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static boolean less(Comparable v, Comparable w) {
        if (v == w) return false;
        return v.compareTo(w) < 0;
    }

    public static void shuffle(Object[] a) {
        for (int i = 0; i < a.length; i++) {
            int r = (int) (Math.random() * (i + 1));
            exch(a, i, r);
        }
    }

    public static void sort(Comparable[] a) {
        shuffle(a);
        sort(a, 0, a.length - 1);
    }

    public static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) return;
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }
    // partition the subarray a[0,..., j -1] <= a[j] <= a[j + 1,...., hi] and return the index j
    public static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        // always set fist element as pivot
        Comparable v = a[lo];
        while (true) {
            // find the item on lo to swap
            while (less(a[++i], v)) {
                if (i == hi) break;
            }

            while (less(v, a[--j])) {
                if (j ==lo) break;
            }
            if (i >= j) break;
            exch(a, i, j);
        }
//        while (i < j) {
//            if (less(a[j--], v)) {
//                exch(a, ++i, ++j);
//            }
//        }
        // put pivot at the a[j]
        exch(a, lo, j);
        // now, a[0,..., j -1] <= a[j] <= a[j + 1,...., hi]
        return j;
    }

    public static void main(String[] args) {
        Quicksort q1 = new Quicksort();
        Comparable[] a = new Comparable[]{1,3,2,6,5,7,4};
        q1.sort(a);
        System.out.println(Arrays.toString(a));

    }
}
