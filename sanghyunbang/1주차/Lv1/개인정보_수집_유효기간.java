// https://school.programmers.co.kr/learn/courses/30/lessons/150370

import java.util.*;


/*
* 고객의 약관 동의 (여기서 약관 종류가 다 다름) -> 개인정보가 n개
*  - 표에서 처럼, 약관종류 - 개인정보 (약관은 오로지 하나구나 1 : 1 매칭된 상태)
*  - 개인정보는 유효기간이 있음
*  - 해당월 기준으로 + n월 하면 마감이라 그 전날 까지만 유효한 상태 
*   = 그래서 1일이 마감인 경우가 예외 케이스가 될 수 있음
*   = 추가로 모든 달이 28일만 있다고 상정 
*/


class Solution {
    
    public Map<String, Integer> expMap = new HashMap<>();
    public List<Integer> list = new ArrayList<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        
        // 오늘 날짜를 기준으로 terms 기준으로 마감 날짜를 미리 정해 놓는게 좋을 거 같은데
        // 그리고 년, 월, 일 -> 하나의 정수값으로 미리 바꿔서 대소 비교 하는게 유리할 듯
        
        // 0. 일단 expMap을 채워놔야 함
        for(int i = 0; i < terms.length; i++){
            expDate(today, terms[i]);
        }
        
        // 1. 이제 해당 일자가 만기인지 확인하고 만기면 list에 채워 넣어야 함
        for(int i = 0; i < privacies.length; i++) {
            if(isExpired(privacies[i])) {
                list.add(i + 1);
            }
        }
        
        Collections.sort(list);
        
        int[] answer = new int[list.size()];
        
        for(int i = 0; i < answer.length; i++){
            answer[i] = list.get(i);
        }
        
        return answer;
    }
    
    public boolean isExpired(String privacy) {
        String[] arr = privacy.split(" ");
        int contractDay = calToInt(arr[0]);
        int ifThenExp = expMap.get(arr[1]);
        
        // 만약 개인정보 등록일 '가정된 만료 과거일'보다 크면 괜찮고 아니면 파기
        if (contractDay > ifThenExp) {
            return false;
        } else {
            return true;
        }
    }
    
    // 정보 수집일이 이 날짜라면 오늘은 이미 마감인 것
    // 이 주어진 값 보다 커야지만 마감이 아닌 것
    public void expDate(String today, String term) {
        
        int current = calToInt(today);
        
        String[] arr = term.split(" ");
        String kind = arr[0];
        int mon = Integer.parseInt(arr[1]) * 28;
        int ifThenExp = current - mon;
        
        // 해당 약관 종류와 마감일 넣기
        expMap.put(kind, ifThenExp);        
    } 
    
    public int calToInt(String date) {
        // date는 "aaaa.nbb.cc" 형태
        String[] arr = date.split("\\.");
        
        int year = Integer.parseInt(arr[0]) * 28 * 12;
        int month = Integer.parseInt(arr[1]) * 28;
        int day = Integer.parseInt(arr[2]);
        
        return year + month + day;
    }
}
