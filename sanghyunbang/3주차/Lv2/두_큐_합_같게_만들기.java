// https://school.programmers.co.kr/learn/courses/30/lessons/118667
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int n = queue1.length;
        int[] q = new int[4 * n];
        
        int nn = q.length;
        int from = 0;
        int to = n-1;
        int size = n;
        
        long part = 0L;
        long tot = 0L;
        
        for (int i = 0; i < n; i++) {
            q[i] = queue1[i];
            part += queue1[i];
            tot += queue1[i];
        }
        
        for (int i = n; i < 2 * n; i++) {
            q[i] = queue2[i - n];
            tot += queue2[i - n];
        }
        
        for (int i = 2 * n; i < nn; i++) {
            q[i] = q[i - 2 * n];
        }
        
        // goal
        long goal = 0L;
        
        if (tot % 2 == 0) {
            goal = tot / 2;
        } else {
            return -1;
        }
        
        int turn = 0;
        
        while (part != goal) {
            
            // if returned to the same split, break!
            if (turn >= 3*n) {
                return -1;
            }
            try{

                if (part < goal) {       
                    to++;
                    part += q[to];
                    turn++;
                } else if (part > goal) {
                    part -= q[from];
                    from++;
                    turn++;
                }   
            } catch (Exception e) {
                System.out.println("from: " + from+" to: " + to+ "length: "+ size);
                e.printStackTrace();
                break;
            }
            
        }
        
        return turn;
    }
    
}
