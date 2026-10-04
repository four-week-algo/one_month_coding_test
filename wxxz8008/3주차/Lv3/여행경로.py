'''
https://school.programmers.co.kr/learn/courses/30/lessons/43164

'''
def solution(tickets):
    
    def dfs(route):
        nonlocal ans
        if ans:
            return 
        if len(route) == len(tickets) + 1: # 사이클을 형성하므로 공항의 수는 티켓의 수보다 1 큼
            ans = route
            return
        for idx, (depart, arrive) in enumerate(tickets):
            if route[-1] == depart and not visited[idx]:
                visited[idx] = True
                dfs(route + [arrive])
                visited[idx] = False
                
    tickets.sort() # 가장 먼저 조건을 만족한 route가 생기면 종료할 수 있도록 dfs 탐색 전 정렬
    
    ans = []
    visited = [False for _ in range(len(tickets))] # (출발, 도착) 티켓 자체를 방문체크
    # 반드시 출발점이어야 하는 "ICN"을 route에 넣어 dfs 탐색 시작
    dfs(["ICN"])
    
    return ans 
