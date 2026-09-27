// https://school.programmers.co.kr/learn/courses/30/lessons/42888

import java.util.*;

class Solution {
    public String[] solution(String[] record) {
        
        List<String> behaviors = new ArrayList<String>();
        List<String> ids = new ArrayList<String>();
        Map<String, String> map = new HashMap<>();
        
        for (String ss : record) {
            String[] arr = ss.split(" ");
            
            if (arr[0].equals("Enter")) {
                behaviors.add("들어왔습니다.");
                ids.add(arr[1]);
                map.put(arr[1], arr[2]);
            } else if (arr[0].equals("Leave")) {
                behaviors.add("나갔습니다.");
                ids.add(arr[1]);
            } else {
                map.put(arr[1], arr[2]);
            }
        }
        
        int nn = behaviors.size();
        String[] answer = new String[nn];
        
        for (int i = 0; i < nn; i++){
            StringBuilder sb = new StringBuilder();
            String nickname = map.get(ids.get(i));
            sb.append(nickname)
                .append("님이 ")
                .append(behaviors.get(i));
            
            answer[i] = sb.toString();
        }
        
        return answer;
    }
}
