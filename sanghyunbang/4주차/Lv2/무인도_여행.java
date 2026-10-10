// https://school.programmers.co.kr/learn/courses/30/lessons/154540
import java.util.*;

class Solution {
    public int[] dr = new int[]{1, -1, 0, 0};
    public int[] dc = new int[]{0, 0, 1, -1};
    public boolean[][] visited;
    public int r;
    public int c;
    public int[] solution(String[] maps) {
        this.r = maps.length;
        this.c = maps[0].length();
        this.visited = new boolean[r][c];
        
        Queue<int[]> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        
        for (int ir = 0; ir < r; ir++){
            for (int ic = 0; ic < c; ic++) {
                
                // 1. 이미 방문한 건 넘기기
                if(visited[ir][ic]) continue;
                visited[ir][ic] = true; // 시작 부분에서 넘기기
                
                int sum = 0;
                
                char val = maps[ir].charAt(ic);
                
                // 만약에 해당 칸이 X면 아래하지 않고 넘기기
                if (val == 'X') {
                    continue;
                }
                
                System.out.println("init part: " + "["+ir+", "+ic+"]");
                
                // 여기선 X가 아니라서 값이 있는 부분의 시작. 새로운 구간의 시작
                sum += Integer.parseInt(String.valueOf(val));
                q.offer(new int[]{ir, ic});
                
                // 연결 되어 있는 지점 내라면, 큐가 비지 않을 것이라고 생각
                while(!q.isEmpty()) {
                    int[] cur = q.poll();
                    int cr = cur[0];
                    int cc = cur[1];

                    for (int i = 0; i < 4; i++) {
                        int nr = cr + dr[i];
                        int nc = cc + dc[i];
                        
                        // 존재할 수 없는 범위거나, 이미 방문을 한 경우 -> 넘기기
                        if (nr < 0 || nr >= r || nc < 0 || nc >= c || visited[nr][nc]) {
                            continue;
                        }
                        
                        val = maps[nr].charAt(nc);
                        // X인 경우는 방문만 하고 넘김
                        if(val == 'X') {
                            visited[nr][nc] = true;
                            continue;
                        } 

                        sum += Integer.parseInt(String.valueOf(val));
                        visited[nr][nc] = true;

                        q.offer(new int[]{nr, nc});
                    }
                }
                
                // q를 빠져나오는게 3번이어야 하는데 왜 5번이나 나오는거지? 
                if (sum > 0) list.add(sum);
                sum = 0;
            }
        }
        
        Collections.sort(list);
        int[] answer = new int[list.size()];
        for(int i = 0; i < list.size(); i++){
            answer[i] = list.get(i);
        }
        
        return (answer.length > 0) ? answer : new int[]{-1};
        
    }
}
