'''
https://school.programmers.co.kr/learn/courses/30/lessons/49189

n개의 노드 (1 ~ n 넘버링)

1번 노드에서 가장 멀리 떨어진 노드의 갯수 구하기 
=> 최단경로 
=> BFS 문제

가장 먼 것은 어떻게 찾아낼 것인가
=> 리스트를 만들고 노드에 적힌 수를 idx로 하여 수시로 저장 후 max(list)와 동일한 idx가 나오면 cnt++ 처리하기

<풀이순서>
1. 인접리스트 만들고,
2. 1부터 넣어 탐색 시작.


'''
from collections import deque
def solution(n, edge):
    
    def bfs(n, start):
        dq = deque()
        dq.append((start, 0)) # (node_name, step) # tuple 가능?
        visited = [False for _ in range(n + 1)]
        visited[start] = True
        while dq:
            node, step = dq.popleft()
            for next in graph[node]:
                if not visited[next]:
                    visited[next] = True
                    step_cnt[next] = step + 1
                    dq.append((next, step + 1))
    
    graph = [[] for _ in range(n + 1)] # 0번 idx padding
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    step_cnt = [0 for _ in range(n + 1)]
    step_cnt[1] = 0 # 필요 없지만 명시적으로 작성
    bfs(n, 1)
    
    cnt = 0
    max_step = max(step_cnt)
    for val in step_cnt[1:]:
        if max_step == val:
            cnt += 1
    
    return cnt
