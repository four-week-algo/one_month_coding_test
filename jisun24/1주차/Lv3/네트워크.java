//https://school.programmers.co.kr/learn/courses/30/lessons/43162

import java.util.*;

class Solution {

    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {

            // 아직 방문하지 않은 컴퓨터라면
            // 새로운 네트워크 발견
            if (!visited[i]) {
                dfs(i, computers, visited);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int current, int[][] computers, boolean[] visited) {
        visited[current] = true;

        for (int next = 0; next < computers.length; next++) {

            // current와 next가 연결되어 있고
            // 아직 방문하지 않았다면
            if (computers[current][next] == 1 && !visited[next]) {
                dfs(next, computers, visited);
            }
        }
    }
}