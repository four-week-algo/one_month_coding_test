// https://school.programmers.co.kr/learn/courses/30/lessons/12981

import java.util.*;

class Solution {
    public int[] solution(int n, String[] words) {

        int[] ans = new int[2];
        HashSet<String> set = new HashSet<>();

        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {

            char last = words[i-1].charAt(words[i-1].length()-1);
            char first = words[i].charAt(0);

            // 끝말잇기 규칙 위반 OR 중복 단어
            if (last != first || set.contains(words[i])) {
                ans[0] = i % n + 1;
                ans[1] = i / n + 1;

                return ans;
            }

            // 탈락하지 않았으면 단어 추가
            set.add(words[i]);
        }

        return ans;
    }
}