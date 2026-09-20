//https://school.programmers.co.kr/learn/courses/30/lessons/43163

import java.util.*;

class Solution {

    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<String> queue = new ArrayDeque<>();

        queue.offer(begin);

        int count = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // 현재 단계에 있는 단어들을 전부 확인
            for (int s = 0; s < size; s++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return count;
                }

                for (int i = 0; i < words.length; i++) {

                    if (visited[i]) {
                        continue;
                    }

                    if (canChange(current, words[i])) {
                        visited[i] = true;
                        queue.offer(words[i]);
                    }
                }
            }

            // 한 단계가 끝났으므로 변환 횟수 증가
            count++;
        }

        return 0;
    }

    private boolean canChange(String a, String b) {
        int diff = 0;

        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
            }

            if (diff > 1) {
                return false;
            }
        }

        return diff == 1;
    }
}
