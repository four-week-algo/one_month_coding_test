//https://school.programmers.co.kr/learn/courses/30/lessons/42587

import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            boolean higher = false;

            for (int i = 0; i < priorities.length; i++) {
                if (priorities[i] > priorities[current]) {
                    higher = true;
                    break;
                }
            }

            if (higher) {
                queue.offer(current);
            }else {
                count++;

                if (current == location) {
                    return count;
                }
                priorities[current] = 0;
            }
        }

        return count;
    }
}


/*
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {

        Queue<Integer> queue = new LinkedList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < priorities.length; i++) {
            queue.offer(i);
            pq.offer(priorities[i]);
        }

        int count = 0;

        while (!queue.isEmpty()) {

            int current = queue.poll();

            // 현재 프로세스의 우선순위가 가장 높은 경우
            if (priorities[current] == pq.peek()) {

                pq.poll();
                count++;

                if (current == location) {
                    return count;
                }
            }

            // 더 높은 우선순위가 있으면 다시 뒤로
            else {
                queue.offer(current);
            }
        }

        return count;
    }
}
*/