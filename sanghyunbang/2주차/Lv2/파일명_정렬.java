// https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.Arrays;

class Solution {
    public String[] solution(String[] files) {
        int nn = files.length;
        
        Integer[] indices = new Integer[nn];
        String[] heads = new String[nn];
        Integer[] numbers = new Integer[nn];
        String[] tails = new String[nn];
        
        // 초기화 시켜놓기
        for (int i = 0; i < nn; i++){
            indices[i] = i;
            
            String[] dec = decompose(files[i]);
            heads[i] = dec[0];
            numbers[i] = Integer.parseInt(dec[1]);
            tails[i] = dec[2];
        }

        // 정렬
        Arrays.sort(indices, (i1, i2) -> {
            // 우선 Head 기준으로 정렬
            int byHead = heads[i1].compareTo(heads[i2]);
            
            if (byHead != 0) {
                return byHead;
            }
            
            return numbers[i1].compareTo(numbers[i2]);
        });
        
        String[] answer = new String[nn];
        
        for (int i = 0; i < nn; i++){
            answer[i] = files[indices[i]];
        }
        return answer;
    }
    
    public String[] decompose(String s) {        
        // number는 연속된 게 중요한 조건
        
        int n = s.length();
        int numStart = 0;
        for (int i = 0; i < n; i++){
            if( isNumber(s.charAt(i)) ) {
                numStart = i;
                break;
            }
        }
        
        int numEnd = numStart;
        for (int i = numStart + 1; i < n; i++){
            if (isNumber(s.charAt(i))) {
                numEnd = i;
            } else {
                break;
            }
        }
        
        String[] decomposed = new String[3];
        
        decomposed[0] = s.substring(0, numStart).toLowerCase();
        decomposed[1] = s.substring(numStart, numEnd + 1);
        decomposed[2] = (numEnd + 1 < n) ? s.substring(numEnd + 1) : "";
        
        return decomposed;
    }
    
    public boolean isNumber(char c) {
        if (c >= '0' && c <= '9') {
            return true;
        } else {
            return false;
        }
    }
}
