package FB;

import sun.jvm.hotspot.utilities.Interval;

import java.util.Arrays;

public class LC253 {
    public static class Interval {
        int start;
        int end;
        public Interval(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }
    public static int minMeettingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        int len = intervals.length;
        // starts and ends
        int[] starts = new int[len];
        int[] ends = new int[len];

        for (int i = 0; i < len; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }

        // sort
        Arrays.sort(starts);
        Arrays.sort(ends);
        int rooms = 0;
        int endPointer = 0;
        for (int i = 0; i < len; i++) {
            if (starts[i] < ends[endPointer]) {
                rooms++;
            }
            else {
                endPointer++;
            }
        }
        return rooms;
    }

    public static void main(String[] args) {
        Interval[] intervals = new Interval[3];
        intervals[0] = new Interval(0, 30);
        intervals[1] = new Interval(5, 10);
        intervals[2] = new Interval(15, 20);
        System.out.println(minMeettingRooms(intervals));
    }
}
