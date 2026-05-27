package com.backendml.N2_MeetingRooms;

import java.util.Collections;
import java.util.List;

public class A_Intervals {
    public boolean canAttendMeetings(List<Interval> intervals) {
        // 1. Handle edge cases (empty or single meeting)
        if (intervals == null || intervals.size() <= 1) {
            return true;
        }

        // 2. Sort meetings by their start times
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        // 3. Check for overlapping intervals
        for (int i = 0; i < intervals.size() - 1; i++) {
            Interval current = intervals.get(i);
            Interval next = intervals.get(i + 1); 

            // If current meeting ends after the next one starts, there is a conflict
            if (current.end > next.start) {
                return false;
            }
        }

        return true;
    }

    private class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
