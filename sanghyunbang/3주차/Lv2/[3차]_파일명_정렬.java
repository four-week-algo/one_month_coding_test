// https://school.programmers.co.kr/learn/courses/30/lessons/17686
// 이전과 다른 방식으로 풀이진행

import java.util.*;
import java.util.regex.*;

class Solution {
    
    private static final Pattern PATTERN = Pattern.compile("^([^0-9]+)([0-9]{1,5})(.*)$");
    
    public String[] solution(String[] files) {
        
        int n = files.length;
        String[] heads = new String[n];
        int[] nums = new int[n];
        Integer[] idx = new Integer[n];
        
        // 파일마다 정규식 매칭
        for (int i = 0 ; i < n ; i++) {
            Matcher m = PATTERN.matcher(files[i]);
            m.matches();
            heads[i] = m.group(1).toLowerCase();
            nums[i] = Integer.parseInt(m.group(2));
            idx[i] = i;
        }        
        // 정렬은 미리 계산한 값 비교
        Arrays.sort(idx, (a, b) -> {
            int c = heads[a].compareTo(heads[b]);
            if ( c != 0) return c;
            return Integer.compare(nums[a], nums[b]);
        });
        
        String[] answer = new String[n];
        for (int i = 0 ; i < n ; i++) answer[i] = files[idx[i]];
            
        return answer;
    }
}
