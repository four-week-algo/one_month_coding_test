//https://school.programmers.co.kr/learn/courses/30/lessons/181187

class Solution {
    public long solution(int r1, int r2) {
        
        // 수직으로 자르기
        
        long answer = 0;
        
        // [1사분면] 좌표 축이 아닌 경우
        for(int x = 1; x < r1; x++) {
            long largeY = findY(r2, x);
            long smallY = findY(r1, x);
            
            // 여기서 largeY는 무조건 포함되므로 중요한건 smallY가 포함되는지 여부
            // 선에 딱 있는 경우가 아니면 포함 안되지만, 딱 선인 경우는 포함
            answer += largeY - smallY;
            
            // 딱 정수인 경우 추가 1
            if (smallY * smallY == 1L * r1 * r1 - 1L * x * x) {
                answer += 1;
            }
        }
        
        // y = 0 인 경우는 헤아리지 않으므로 딱 그 숫자만큼 1 ... y (y개)
        for(int x = r1; x < r2; x++) {
            long y = findY(r2, x);
            answer += y;
        }
        
        // 절편 개수 y = 0 인 경우만 보고 -> *4 하면 됨.
        answer += r2 - r1 + 1;
        
        return answer * 4;
    }
    
    // 좌표 선은 제외하고 
    public long findY (int r, int x) {
        
        // x^2 + y^2 = r^2
        // y^2 = r^2 - x^2
        // y = root (r^2 - x^2)
        
        return (long) Math.sqrt(1L * r * r - 1L * x * x);
    }
}
