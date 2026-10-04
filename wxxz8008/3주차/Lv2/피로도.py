'''
https://school.programmers.co.kr/learn/courses/30/lessons/87946

'''

def solution(k, dungeons):
    
    def dfs(hp, cnt):
        nonlocal ans
        ans = max(ans, cnt)
        
        for i in range(n):
            least_hp, exhaust_hp = dungeons[i]
            if hp >= least_hp and not visited[i]:
                visited[i] = True
                dfs(hp - exhaust_hp, cnt + 1)
                visited[i] = False
        
    n = len(dungeons)
    visited = [False for _ in range(n)]
    ans = 0
    dfs(k, 0)
    
    return ans
