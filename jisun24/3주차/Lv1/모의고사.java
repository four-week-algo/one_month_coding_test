// https://school.programmers.co.kr/learn/courses/30/lessons/42840

class Solution {
    public int[] solution(int[] answers) {
        int n = answers.length;
        
        int[] pattern1 = {1,2,3,4,5};
        int[] pattern2 = {2,1,2,3,2,4,2,5};
        int[] pattern3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] cnt = new int[3];
        
        for(int i = 0; i < n; i++){
            if(pattern1[i % pattern1.length] == answers[i]) cnt[0]++;
            if(pattern2[i % pattern2.length] == answers[i]) cnt[1]++;
            if(pattern3[i % pattern3.length] == answers[i]) cnt[2]++;
        }
        
        int maxValue = 0;
        
        for(int i = 0; i < 3; i++){
            if(cnt[i] > maxValue) {
                maxValue = cnt[i];
            }
        }
        
        int count = 0;
        
        for(int i = 0; i < 3; i++){
            if(cnt[i] == maxValue) {
                count++;
            }
        }
        
        int[] answer = new int[count];
        int idx = 0;
        
        for(int i = 0; i < 3; i++){
            if(cnt[i] == maxValue){
                answer[idx] = i + 1;
                idx++;
            }
        }
        
        return answer;
    }
}