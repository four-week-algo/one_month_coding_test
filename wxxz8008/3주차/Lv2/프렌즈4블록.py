'''
https://school.programmers.co.kr/learn/courses/30/lessons/17679

2 x 2 애니팡 (겹쳐도 괜찮음) => 구현 문제
터지면 아래 퍼즐이 내려와서 다시 터짐

m x n grid
flag 하나 두고 while문 계속 탐색할지 말지 결정하면 될 듯

'''
def solution(m, n, board):
    
    ''' 터진 값 없애고 재정비하는 함수 '''
    def arrange():
        for j in range(n):
            
            stack = []
            for i in range(m):
                if board[i][j] != '':
                    stack.append(board[i][j])
        
            for i in range(m-1, -1, -1):
                if stack:
                    val = stack.pop()
                    board[i][j] = val
                else:
                    board[i][j] = '' # 공백으로 넣어두기
    
    for i in range(m):
        board[i] = list(board[i])
    
    success = True # 한 번의 while문에서 터진 게 있는지
    while success:
        explore_set = set() # 이번 턴에 터질 idx 저장
        for i in range(m - 1):
            for j in range(n - 1):
                # [i:i+2], [j:j+2]
                if board[i][j] != '':
                    if board[i][j] == board[i+1][j] == board[i][j+1] == board[i+1][j+1]:
                        explore_set.add((i, j))
                        explore_set.add((i+1, j))
                        explore_set.add((i, j+1))
                        explore_set.add((i+1, j+1))
        if not explore_set:
            success = False
            continue
        # 터뜨리기
        for i, j in explore_set:
            board[i][j] = ''
        arrange()
    
    answer = 0
    for i in range(m):
        for j in range(n):
            if board[i][j] == '':
                answer += 1
        
    return answer
