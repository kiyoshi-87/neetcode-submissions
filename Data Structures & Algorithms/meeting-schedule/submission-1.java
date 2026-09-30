/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        intervals = intervals.stream()
                .sorted((a, b) -> a.start - b.start)
                .toList();
        
        int last = 0;

        for (Interval interval : intervals) {
            if (last > interval.start) {
                return false;
            }
            
            last = interval.end;
        }
        
        return true;
    }
}
