// https://school.programmers.co.kr/learn/courses/30/lessons/12900

class Solution {
    public int solution(int n) {
        
        if (n == 1) return 1;
        if (n == 2) return 2;

        int a = 1;
        int b = 2;
        
        for (int i = 3; i <= n; i++) {
            int c = (a + b) % 1000000007;
            a = b;
            b = c;
        }
        
        return b;
    }
}
