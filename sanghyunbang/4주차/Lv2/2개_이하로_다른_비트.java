// https://school.programmers.co.kr/learn/courses/30/lessons/77885
class Solution {
    public long[] solution(long[] numbers) {
        int nn = numbers.length;
        long[] answer = new long[nn];
        
        for (int i = 0; i < nn; i++){
            answer[i] = solve(numbers[i]);
        }
        return answer;
        
        // 숫자를 직접 올리면서 하면 시간 초과나고 자릿수 확인하는 식으로 해야 할 듯
    }
    
    public long solve(long l) {
        String bin = Long.toBinaryString(l);
        int n = bin.length();
        int zeroIdx = -1;
        
        for(int i = bin.length() - 1 ; i >= 0; i--) {
            if(bin.charAt(i) == '0') {
                zeroIdx = i;
                break;
            }
        }
        
        // 자릿수를 올리지 않아도 되는 경우
        if(zeroIdx >= 0) {
            StringBuilder sb = new StringBuilder();
            
            for (int i = 0; i < n; i++) {
                if (i == zeroIdx) {
                    sb.append('1');
                } else if ( i == zeroIdx + 1) {
                    sb.append('0');
                } else {
                    sb.append(bin.charAt(i));
                }
            }
            
            return Long.parseLong(sb.toString(), 2);
        }
        // 자릿수를 올려야 하는 경우 : 모두 다 1로만 되어 있는 경우 
        else {
            StringBuilder sb = new StringBuilder();
            sb.append('1');
            sb.append('0');
            
            for (int i = 1; i < n; i++){
                sb.append(bin.charAt(i));
            }
            return Long.parseLong(sb.toString(), 2);
        }
    }
}
