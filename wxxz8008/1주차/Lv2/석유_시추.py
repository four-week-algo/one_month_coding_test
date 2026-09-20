# https://school.programmers.co.kr/learn/courses/30/lessons/250136

'''
n x m grid (500 x 500)

0; 빈 땅
1; 석유

하나의 석유 블럭마다 지나친 '열'을 저장해두고,
하나의 BFS 탐색이 끝날 때 해당 '열'에 값 더하기

숫자 1부터 시작함에 유의! 
'''
from collections import deque

def solution(land):
    
    def bfs(n, m):
        dq = deque()
        columns_set = set()
        oil_cnt = 0 # 명시적 선언

        for i in range(n):
            for j in range(m):
                # 방문하지 않은 석유라면
                if land[i][j] == 1 and not visited[i][j]:
                    dq.append((i, j))
                    visited[i][j] = True
                    columns_set.add(j)
                    oil_cnt += 1
                    
                    while dq:
                        x, y = dq.popleft()
                        for k in range(4):
                            nx, ny = x + dx[k], y + dy[k]
                            if 0 <= nx < n and 0 <= ny < m and land[nx][ny] == 1 and not visited[nx][ny]:
                                dq.append((nx, ny))
                                visited[nx][ny] = True
                                columns_set.add(ny)
                                oil_cnt += 1
                    
                    if oil_cnt != 0:
                        for col in columns_set:
                            oil[col] += oil_cnt
                        columns_set = set()
                        oil_cnt = 0
                            
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    n, m = len(land), len(land[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    oil = [0 for _ in range(m)]
    
    # bfs 탐색
    bfs(n, m)
    
    return max(oil)
