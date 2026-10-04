// https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;

class Solution {

    Set<Integer> set = new HashSet<>();
    boolean[] visited;

    public int solution(String numbers) {
        int n = numbers.length();
        
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = numbers.charAt(i) - '0';
        }

        visited = new boolean[n];

        // 모든 숫자 조합 만들기
        dfs(arr, "");

        int ans = 0;

        // 만들어진 숫자들 중 소수 개수 세기
        for (int num : set) {
            if (isPrime(num)) {
                ans++;
            }
        }

        return ans;
    }

    // 순열 만들기
    public void dfs(int[] arr, String current) {
        for (int i = 0; i < arr.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;

            String next = current + arr[i];

            set.add(Integer.parseInt(next));

            dfs(arr, next);

            visited[i] = false;
        }
    }

    // 소수 판별
    public boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }

        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }

        return true;
    }
}