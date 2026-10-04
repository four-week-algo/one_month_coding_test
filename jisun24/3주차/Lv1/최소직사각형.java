//https://school.programmers.co.kr/learn/courses/30/lessons/86491

class Solution {
    public int solution(int[][] sizes) {
        int n = sizes.length;
        int w = 0, h = 0, maxW = 0, maxH = 0;
        
        for(int i = 0; i < n; i++){
            w = Math.max(sizes[i][0], sizes[i][1]);
            h = Math.min(sizes[i][0], sizes[i][1]);
            maxW = Math.max(maxW, w);
            maxH = Math.max(maxH, h);
        }
        
        int ans = 0;
        ans = maxW * maxH;
        
        return ans;
    }
}

