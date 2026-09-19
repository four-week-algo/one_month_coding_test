// https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;

class Solution {
    
    public Map<Integer, Integer> accTime = new HashMap<>();
    public int[][] refinedRec;
    public int maxT = 23 * 60 + 59;
    
    public int[] solution(int[] fees, String[] records) {
        
        
        int baseMin = fees[0];
        int baseFee = fees[1];
        int unitMin = fees[2];
        int unitCost = fees[3];
        
        // 0-1. 여기에서 순회하면서 자동차 번호를 집어 넣기
        for (String st : records) {
            String[] arr = st.split(" ");
            accTime.put(Integer.parseInt(arr[1]), 0); // 일단은 0으로 초기화
        }
        
        // 0-2. refined 초기화 해놓기
        
        int rn = records.length;
        refinedRec = new int[rn][3];
        
        for (int i = 0; i < rn; i++) {
            String s = records[i];
            String[] arr = s.split(" ");
            
            String[] t = arr[0].split(":");
            int tt = Integer.parseInt(t[0]) * 60 + Integer.parseInt(t[1]);
            
            int carNum = Integer.parseInt(arr[1]);
            
            // 입차는 0 출차는 1
            int type = arr[2].equals("IN") ? 0 : 1;
            
            int[] input = {tt, carNum, type};
            
            refinedRec[i] = input;
        }
        
        List<Integer> carNums = new ArrayList<>(accTime.keySet());
        Collections.sort(carNums);
        int answer[] = new int[carNums.size()];
        // 이제 여기서 순회하면서 찾아보기. 다 순회해도 1000*1000이라 괜찮음
        
        for (int i = 0; i < answer.length; i++){
            int car = carNums.get(i);
            
            // 계산 넣기
            cal(car);
            
            int accT = accTime.get(car);
            int cost = baseFee + (int) Math.ceil((double) (accT - baseMin) / unitMin) * unitCost;
            
            if (accT <= baseMin) {
                answer[i] = baseFee;
            } else {
                answer[i] = cost;
            }
        }
        
        return answer;
    }
    
    // 특정 차량의 누적 시간 채우기
    public void cal(int carNum) {
        
        Deque<Integer> dq = new ArrayDeque<>();
        
        for (int[] data : refinedRec) {
            
            if (data[1] != carNum) continue;
            
            if (data[2] == 0) {
                dq.offer(data[0]);
            } else {
                accTime.put( carNum,  accTime.get(carNum) + (data[0] - dq.poll()) );
            }
        }
        
        if(!dq.isEmpty()) {
            accTime.put( carNum, accTime.get(carNum) + ( maxT - dq.poll()) );
        }
    }
}
