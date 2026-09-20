// https://school.programmers.co.kr/learn/courses/30/lessons/468378
import java.util.function.Function;

class Solution {
    public int solution(int[] depth, int money, Function<Integer, Integer> excavate) {
        
        int w = depth.length; // 열 개수
        
        // 깊이 배열 0시작 -> 1시작으로 바꾸기.
        // excavate는 1부터 시작하는 인덱스라 헷깔림
        int[] d = new int[w + 1];
        for (int i = 1; i <= w; i++) {
            d[i] = depth[i - 1];
        }
        
        // dp 설계
        // (l, r)열에 있다는 거 알 떄, 최대 비용 (최선 기준) - maxmin
        int[][] dp = new int[w + 2][w + 2]; 
        
        // 후보가 (l, r)일 때 파야하는 곳 저장해두는 거
        int[][] choice = new int[w + 2][w + 2];
        
        // 표 채우기
        for (int len = 1; len <= w; len++) {
            
            // 길이가 len인 구간을 왼쪽부터 하나씩 훑음
            // 시작이 l이면 끝은 r = l + len -1
            // r이 w를 넘으면 안되니까 l + len -1 <= w 까지만
            
            for (int l = 1; l + len -1 <= w; l++){
                int r = l + len -1;
                
                int best = Integer.MAX_VALUE; // 지금 까지 본 k 중 가장 싼 비용 넣을 자리
                int bestK = l; // 임의의 값으로 일단 
                
                for (int k = l; k <= r; k++) {
                    
                    int left = dp[l][k - 1]; // 결과가 -1인 경우
                    int right = dp[k + 1][r]; // 결과가 1인 경우
                    
                    int cost = d[k] + Math.max(left, right);
                    
                    // k는 내가 가장 싼 거 고름
                    if (cost < best) {
                        best = cost;
                        bestK = k;
                    }
                }
                
                // 다 돌았으면:
                // best = 후보 l ~ r에서 제일 잘 팠을 때 앞으로 드는 최악 비용
                // bestK = 그 때 파야하는 열
                dp[l][r] = best;
                choice[l][r] = bestK;
            }
        }
        
        int l = 1;
        int r = w;
        
        while (true) {
            
            // 후보가 [l, r]일 때 파야할 열이 이미 표에 적혀있음
            int k = choice[l][r];
            
            // 여기서 실제로 파고 비용 d[k]가 나감
            int res = excavate.apply(k);
            
            if (res == 0) {
                return k;
            } else if (res == -1) {
                r = k - 1;
            } else {
                l = k + 1;
            }
        }
    }
}
