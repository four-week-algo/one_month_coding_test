// https://school.programmers.co.kr/learn/courses/30/lessons/131704

import java.util.*;

class Solution {
    
    public Deque<Integer> st = new ArrayDeque<>();
    public int belt = 1;
    public int answer = 0;
    
    public int solution(int[] order) {
        
        for (int i = 0; i < order.length; i++){
            if (!execute(order[i])) {
                break;
            }
            
        }
        
        return answer;
    }
    
    public boolean execute(int v) {
        
        // 1. 주 벨트 값 보기
        if (!st.isEmpty() && st.peek() > v) {
            return false;
        } 
        
        // 2. 주 벨트 안쪽에 있어면 보조벨트로 옮기기
        if (v >= belt) {
            for (int i = belt; i <= v; i++){
                st.push(i);
            }
            belt = v + 1;
        }
        st.pop();
        answer++;
        return true;
    }
}
