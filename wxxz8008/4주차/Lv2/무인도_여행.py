'''
https://school.programmers.co.kr/learn/courses/30/lessons/154540

직사각형 grid 
X: 바다
1~9: 무인도

return [각 섬에서 머물 수 있는 최대 일자] - 오름차순
or 
return -1 

bfs로 탐색하며 영역 합산하면 됨

'''

from collections import deque

def solution(maps):
    
    def bfs(x, y):
        days = int(maps[x][y]) # 누적하여 합산해가기
        dq = deque()
        dq.append((x, y))
        visited[x][y] = True
        
        while dq:
            x, y = dq.popleft()
            for k in range(4):
                nx, ny = x + dx[k], y + dy[k]
                if 0 <= nx < n and 0 <= ny < m:
                    if maps[nx][ny] != 'X' and not visited[nx][ny]:
                        dq.append((nx, ny))
                        visited[nx][ny] = True
                        days += int(maps[nx][ny])
        answer.append(days)
    
    answer = []
    n, m = len(maps), len(maps[0])
    visited = [[False for _ in range(m)] for _ in range(n)]
    dx, dy = [-1, 1, 0, 0], [0, 0, -1, 1]
    
    for i in range(n):
        for j in range(m):
            if maps[i][j] != 'X' and not visited[i][j]:
                bfs(i, j)
    
    if not answer:
        return [-1]
    
    return sorted(answer)
