// https://school.programmers.co.kr/learn/courses/30/lessons/49993
import java.util.*;

class Solution {
    
    String skill;
    Map<Character, Integer> map = new HashMap<>();
    Set<Character> set = new HashSet<>();
    
    String[] skill_trees;
    String[] trimed_trees;
    
    public int solution(String skill, String[] skill_trees) {
        
        this.skill = skill;
        this.skill_trees = skill_trees;
        int n = skill_trees.length;
        trimed_trees = new String[n];
        
        makeMapAndSet();
        trim();
        
        return calc();
    }
    
    public void makeMapAndSet() {
        for (int i =0; i < skill.length(); i++) {
            map.put(skill.charAt(i), i);
        }
        set = map.keySet();
    }
    
    public void trim() {
        
        for (int i = 0; i < skill_trees.length; i++) {
            StringBuilder sb = new StringBuilder();
            String s = skill_trees[i];
            int n = s.length();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);

                if (set.contains(c)) {
                    sb.append(c);
                }
            }
            
            trimed_trees[i] = sb.toString();
        }
    }
    
    public int calc() {
        
        int result = 0;
        
        for (int idx = 0; idx < trimed_trees.length; idx++) {
            
            String s = trimed_trees[idx];
            
            int prev = -1;
            
            // [!!!!!] 이걸 false로 하게 되면, skill 이 "" 으로 주어진 경우를 false로 잘못처리
            // 테스트 케이스 실패 이유
            boolean pass = true;
            
            for (int i = 0; i < s.length(); i++){
                int cur = map.get(s.charAt(i));
                // 바로 이전 값이어야만 함 prev가
                if (prev == cur - 1) {
                    prev = cur; // 다음으로 넘어 가면 됨
                    pass = true;
                } else {
                    pass =false;
                    break;
                }
            }
            
            if (pass) {
                result++;
                System.out.println("passed one : "+idx);
            }
        }
        
        return result;
    }
}
