// https://school.programmers.co.kr/learn/courses/30/lessons/172927

import java.util.*;

class Solution {
    
    public int quo;
    public int rem;
    public int[][] fatigues;
    public int[] state;
    public String[] minerals;
    public int answer = Integer.MAX_VALUE; 
    public int solution(int[] picks, String[] minerals) {
        
        // 완료 조건 : 
        // - 곡괭이를 다 쓰거나
        // - 광물을 모두 캐거나 
        System.out.println("check");

        int n = minerals.length;
        this.quo = n / 5;
        this.rem = n % 5;
        
        this.fatigues = new int[quo + (int) Math.ceil(rem / 5.0)][3];
        
        this.minerals = minerals;
        this.state = picks;
        System.out.println("check1");
        setVal();
        System.out.println("check2");
        System.out.println(fatigues[0][1]);
        dfs(0, 0);
        return answer;
    }
    
    public void dfs(int depth, int val) {
        
        // 종료조건 1 : 더이상 곡괭이 없는 경우
        if (state[0] == 0 && state[1] == 0 && state[2] == 0) {
            answer = Math.min(answer, val);
            return;
        }
        
        // 종료조건 2 : 최대 깊이의 도달한 경우
        if (depth >= quo + (int) Math.ceil(rem / 5.0)) {
            answer = Math.min(answer, val);
            return;        
            
        }
        
        for (int i = 0; i < 3; i++) {
            // 만약 해당 곡괭이 없으면 다음으로 넘어가보기
            if (state[i] == 0) continue;
            
            state[i] -= 1;
            
            // val을 유지하기 위해서 임시값 사용
            int tmpFatigue = val;
            tmpFatigue += fatigues[depth][i];
            
            dfs(depth + 1, tmpFatigue);
            
            // backtracking : 여기서 state되돌리기
            state[i] += 1;
        }
    }

    public void setVal() {
        for (int i = 0 ; i <= quo; i++){
            int[] arr = new int[3];
            int useD = 0;
            int useI = 0;
            int useS = 0;
            
            if (i == quo) {
                if (rem == 0) break;
                if (rem > 0) {
                    for (int j = 0; j < rem; j++){
                        String in = minerals[5*i + j];
                        useD += useDia(in);
                        useI += useIron(in);
                        useS += useStone(in);                    
                    }                
                }
                arr[0] = useD;
                arr[1] = useI;
                arr[2] = useS;

                fatigues[i] = arr;
                break;
            }
            
            for (int j = 0; j < 5; j++) {
                String in = minerals[5*i + j];
                useD += useDia(in);
                useI += useIron(in);
                useS += useStone(in);
            }
            arr[0] = useD;
            arr[1] = useI;
            arr[2] = useS;
            
            fatigues[i] = arr;
        }
    }
    
    
    
    public int useDia(String s) {
        return 1;
    }
    
    
    public int useIron(String s) {
        if (s.equals("diamond")) {
            return 5;
        } else {
            return 1;
        }
    }
    
    
    public int useStone(String s) {
        if (s.equals("diamond")) {
            return 25;
        } else if (s.equals("iron")) {
            return 5;
        } else {
            return 1;
        }
    }
}
