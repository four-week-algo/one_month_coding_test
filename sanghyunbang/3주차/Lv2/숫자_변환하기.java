//https://school.programmers.co.kr/learn/courses/30/lessons/154538
import java.util.*;

class Solution {
    public int solution(int x, int y, int n) {
        boolean[] visited = new boolean[y + 1];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, x});
        visited[x] = true;
        
        while(!q.isEmpty()) {
            int[] cur = q.poll();
            int depth = cur[0];
            int val = cur[1];
            
            if (val == y) return depth;
            
            for (int nx : new int[]{val + n, val * 2, val * 3}) {
                if (nx > y || visited[nx]) continue;
                q.offer(new int[]{depth + 1, nx});
                visited[nx] = true;
            }
        }
        return -1;
    }
}
