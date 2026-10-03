// https://school.programmers.co.kr/learn/courses/30/lessons/17679?language=java
import java.util.*;

class Solution {
    
    public char[][] nboard;
    public int nr;
    public int nc;
    public Queue<int[]> q = new ArrayDeque<>();
    public int answer = 0;
    public int solution(int m, int n, String[] board) {
        this.nr = m;
        this.nc = n;
        this.nboard = new char[nr][nc];
        
        // 1. init new board
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                nboard[r][c] = board[r].charAt(c);
            }
        }
        
        // check whether list is blank
        find();
        while(!q.isEmpty()) {
            doBlank();
            rearrange();
            find();
        }
        
        for (int r = 0; r < nr; r++){
            for (int c = 0; c < nc; c++){
                if (nboard[r][c] == '.') answer++;
            }
        }
        
        return answer;
    }
    
    public void find() {
        for (int r = 0; r < nr-1; r++){
            for(int c = 0; c < nc - 1; c++){                
                char base = nboard[r][c];
                
                // check 0 .
                if(base == '.') continue;
                // check 1. right
                if (base != nboard[r][c+1]) continue;
                // check 2. down
                if (base != nboard[r+1][c]) continue;
                // check 3. right down
                if (base != nboard[r+1][c+1]) continue;
                
                // 2*2 same
                int[] ele = {r, c};
                q.offer(ele);
            }
        }
    }
    
    public void doBlank() {
        while(!q.isEmpty()) {
            int[] point = q.poll();
            
            int rr = point[0];
            int cc = point[1];
            
            // make blanks -> Z means blank
            // 1. base
            nboard[rr][cc] = '.';
            // 2. right
            nboard[rr][cc+1] = '.';
            // 3. down
            nboard[rr+1][cc] = '.';
            // 4. right down
            nboard[rr+1][cc+1] = '.';
        }
    }
    
    public void rearrange() {
        for (int c = 0; c < nc ; c++) {
            StringBuilder sb = new StringBuilder();
            for (int r = 0; r < nr; r++) {
                if (nboard[r][c] != '.') {
                    sb.append(nboard[r][c]);
                }
            }
            
            int bn = sb.length();
            
            for(int n = 0; n < nr - bn; n++){
                sb.insert(0, '.');
            }
            
            for (int r = 0; r < nr; r++) {
                nboard[r][c] = sb.charAt(r); 
            }
        }
    }
    
}
