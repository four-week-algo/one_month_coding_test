// https://school.programmers.co.kr/learn/courses/30/lessons/42579

import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> total = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        for (int i = 0; i < genres.length; i++) {
            total.put(genres[i], total.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<String> genreList = new ArrayList<>(total.keySet());

        genreList.sort((a, b) -> total.get(b) - total.get(a));

        for (String genre : genreList) {
            ArrayList<Integer> songs = new ArrayList<>();

            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(genre)) {
                    songs.add(i);
                }
            }

            songs.sort((a, b) -> {
                if (plays[a] == plays[b]) {
                    return a - b;
                }
                return plays[b] - plays[a];
            });

            for (int i = 0; i < Math.min(2, songs.size()); i++) {
                result.add(songs.get(i));
            }
        }

        int[] answer = new int[result.size()];

        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }

        return answer;
    }
}