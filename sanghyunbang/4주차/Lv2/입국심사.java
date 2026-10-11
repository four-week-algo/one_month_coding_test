// https://school.programmers.co.kr/learn/courses/30/lessons/43238
import java.util.*;

class Solution {
    int[] times;
    int n;
    int m;
    public long solution(int n, int[] times) {
        this.n = n;
        
        int m = times.length;
        this.m = m;
        
        Arrays.sort(times);
        this.times = times;
        
        long mEle = times[m-1];
        long max = mEle * n;
        
        long right = max; // 시작 target은 max로 시작
        long left = 0;
        long answer = max;
        
        // 최솟값 찾기
        while (left <= right) {
            long mid = left + (right - left) / 2;
            if (can(mid)) {
                answer = mid;
                right = mid -1;
            } else {
                left = mid +1;
            }
        }
        
        return answer;
    }
    
    public boolean can(long target) {
        // target 전까지 times에서 큰 값부터 채워 넣기
        // 그렇게 해서 n -> 0에 도달해야 함
        long remains = n;
        
        for (int i = m-1; i >= 0; i--) {
            remains -= target / times[i];
        }
        
        return (remains <= 0) ? true : false;
    }
}
