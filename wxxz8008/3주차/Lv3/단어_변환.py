'''
https://school.programmers.co.kr/learn/courses/30/lessons/43163

begin -> target 변환하는 **가장 짧은 과정** => bfs 유력

ex. hit -> cog; 최소 몇 단계를 거쳐야하는지 return

'''

from collections import deque
def solution(begin, target, words):
    # 단어의 수가 
    def diff_one(word_a, word_b):
        diff_cnt = 0
        for i in range(n):
            if word_a[i] != word_b[i]:
                diff_cnt += 1
        # 알파벳이 딱 1개 달라야 변경할 수 있음
        if diff_cnt == 1:
            return True
        return False
            
    
    def bfs(word, cnt):
        dq = deque()
        visited = [False for _ in range(len(words))]
        dq.append((word, cnt))
        while dq:
            change, cnt = dq.popleft()
            if target == change:
                return cnt
            for i in range(len(words)):
                if not visited[i] and diff_one(words[i], change):
                    dq.append((words[i], cnt + 1))
                    visited[i] = True 
    
    if target not in words:
        return 0
    n = len(target)
    
    return bfs(begin, 0)
