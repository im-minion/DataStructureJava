package easy;

import java.util.Arrays;
import java.util.Comparator;

public class Q_252_MeetingRooms {
    public static void main(String[] args) {
        Interval[] intervals = new Interval[]{
                new Interval(40, 60),
                new Interval(60, 100),
                new Interval(0, 20),
                new Interval(20, 40),
        };
        System.out.println(canAttendMeetings(intervals));
    }

    public static boolean canAttendMeetings(Interval[] intervals) {
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });
        for (Interval i : intervals) {
            System.out.println(i.start + " -> " + i.end);
        }
        for (int i = 0; i < intervals.length - 1; i++) {
            if (intervals[i].end > intervals[i + 1].start) {
                return false;
            }
        }
        return true;
    }
}

class Interval {
    int start;
    int end;

    Interval() {
        start = 0;
        end = 0;
    }

    Interval(int s, int e) {
        start = s;
        end = e;
    }
}