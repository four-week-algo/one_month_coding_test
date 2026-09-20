# https://school.programmers.co.kr/learn/courses/30/lessons/43162

def solution(n, computers):
    
    def dfs(node):
        visited[node] = True
        for i in range(n): # computers[node]:
            if node != i and computers[node][i] == 1 and not visited[i]:
                dfs(i)
        return
            
    cnt = 0
    # 방문하지 않았으면 dfs 탐색하면 됨
    visited = [False for _ in range(n)]
    for i in range(n):
        if not visited[i]:
            dfs(i)
            cnt += 1
    
    return cnt
