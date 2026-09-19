// https://school.programmers.co.kr/learn/courses/30/lessons/340212
import java.util.*;

class Solution {
    int n;
    public int[] diffs;
    public int[] times;
    public long limit;
    public int solution(int[] diffs, int[] times, long limit) {
        n = diffs.length;
        this.diffs = diffs;
        this.times = times;
        this.limit = limit;
        
        int min = 1;
        int max = 0;
        for (int d : diffs) {
            max = Math.max(d, max);
        }
        int ans = 0;
        
        while (min <= max) {
            int mid = min + (max - min) / 2;
            
            if (can(mid)) {
                ans = mid;
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        
        return ans;
    }
    
    public boolean can(int lv) {
        
        // init
        int time_prev = times[0];
        long acc = times[0];
        int time_cur;
        
        for (int i = 1; i < n; i++) {
            time_cur = times[i];
            int diff = diffs[i];
            int gap = diff - lv;
            if (gap > 0) {
                acc += (time_prev + time_cur) * gap + time_cur;
            } else {
                acc += time_cur;
            }
            
            time_prev = time_cur;
        }
        
        return (acc <= limit) ? true : false;
    }
}
