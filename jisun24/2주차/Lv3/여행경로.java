//https://school.programmers.co.kr/learn/courses/30/lessons/43164?language=java

import java.util.*;

class Solution {
    boolean[] visited;
    String[] answer;

    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];

        // 알파벳 순으로 먼저 탐색할 수 있게 정렬
        Arrays.sort(tickets, (a, b) -> {
            if (a[0].equals(b[0])) {
                return a[1].compareTo(b[1]);
            }
            return a[0].compareTo(b[0]);
        });

        List<String> path = new ArrayList<>();
        path.add("ICN");

        dfs("ICN", tickets, path);

        return answer;
    }

    private boolean dfs(String current, String[][] tickets, List<String> path) {

        // 모든 항공권을 사용한 경우
        if (path.size() == tickets.length + 1) {
            answer = path.toArray(new String[0]);
            return true;
        }

        for (int i = 0; i < tickets.length; i++) {

            // 이미 사용한 항공권은 패스
            if (visited[i]) {
                continue;
            }

            // 현재 공항에서 출발하는 항공권인지 확인
            if (tickets[i][0].equals(current)) {

                visited[i] = true;
                path.add(tickets[i][1]);

                // 정답을 찾으면 바로 종료
                if (dfs(tickets[i][1], tickets, path)) {
                    return true;
                }

                // 해당 경로가 실패하면 되돌리기
                visited[i] = false;
                path.remove(path.size() - 1);
            }
        }

        return false;
    }
}

