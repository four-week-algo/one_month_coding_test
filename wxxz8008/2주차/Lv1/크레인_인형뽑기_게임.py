'''
n x n grid (정사각)

- 가장 위에 있는 인형 -> 바구니로 이동
- 동일 2개 쌓이면 터지게 됨
- 아무것도 없으면 아무것도 집지 않은 채로 끝남

board; n x n grid (1 ~ 100 인형 / 0은 빈 칸)
moves; 이동 내역

터뜨려 사라진 인형의 개수 return

'''

def solution(board, moves):
    
    def explore():
        cnt = 0 # 이번 폭발에 터진 인형 count (0 or 2)
        if len(stack) > 1:
            if stack[-1] == stack[-2]:
                cnt = 2
                stack.pop()
                stack.pop()
        return cnt
    
    answer = 0
    stack = []
    # 크레인이 내려갈 위치 (padding 포함)
    for move in moves:
        j = move - 1
        for i in range(len(board)):
            if board[i][j] == 0:
                continue
            # 인형인 경우
            stack.append(board[i][j])
            board[i][j] = 0
            answer += explore()
            break
        
    return answer
