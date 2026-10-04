// https://school.programmers.co.kr/learn/courses/30/lessons/42586

import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int n = progresses.length;
        
        int[] days = new int[n];
        for(int i = 0; i < n; i++){
            int remain = 100 - progresses[i];
            int day = remain / speeds[i];
            if(remain % speeds[i] != 0) day++;
            
            days[i] = day;
        }
        
        List<Integer> result = new ArrayList<>();

        int standard = days[0];
        int count = 1;

        for(int i = 1; i < n; i++){

            // 앞 기능이 배포될 때 이미 끝나있는 경우
            if(days[i] <= standard){
                count++;
            }

            // 앞 기능보다 늦게 끝나는 경우
            else {
                result.add(count);

                standard = days[i];
                count = 1;
            }
        }

        result.add(count);

        // List<Integer> → int[]
        int[] answer = new int[result.size()];

        for(int i = 0; i < result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }
}
