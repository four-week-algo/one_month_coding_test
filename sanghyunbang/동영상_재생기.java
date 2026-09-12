// https://school.programmers.co.kr/learn/courses/30/lessons/340213

import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        
        int n = commands.length;
        int cur = secToInt(pos);
        
        int len = secToInt(video_len);
        int start = secToInt(op_start);
        int end = secToInt(op_end);
        
        //0. 맨처음 오프닝인지 확인
        cur = skipCheck(cur, start, end);
        
        for (int i = 0; i < n; i++) {
            String command = commands[i];
            
            if (command.equals("prev")){
                cur = skipCheck(cur, start, end);
                cur = prev(cur);
            } else {
                cur = skipCheck(cur, start, end);
                cur = next(cur, len);
            }
        }
        
        String answer = intToSec(skipCheck(cur, start, end));
        return answer;
    }
    
    public int prev(int cur) {
        int res = cur - 10;
        return (res > 0) ? res : 0; 
    }
    
    public int next(int cur, int len) {
        int res = cur + 10;
        return (res < len) ? res : len;
    }
    
    public int skipCheck(int cur, int start, int end) {
        
        if (cur >= start && cur <= end) {
            return end;
        }
        
        return cur;
    }
    
    public int secToInt(String str) {
        String[] arr = str.split(":");
        return Integer.parseInt(arr[0]) * 60 + Integer.parseInt(arr[1]);
    }
    
    public String intToSec(int num) {
        int ss = num % 60;
        int mm = num / 60;
        
        StringBuffer sb = new StringBuffer();
        
        if (mm < 10) {
            sb.append('0').append(mm);
        } else {
            sb.append(mm);
        }
        
        sb.append(':');
            
        if (ss < 10) {
            sb.append('0').append(ss);
        } else {
            sb.append(ss);
        }
        return sb.toString();
    }
}
