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