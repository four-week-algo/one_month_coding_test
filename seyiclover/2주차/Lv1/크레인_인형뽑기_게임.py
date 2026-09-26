# https://school.programmers.co.kr/learn/courses/30/lessons/64061
def solution(board, moves):
    answer = 0
    stack = []

    # 크레인의 이동 위치를 하나씩 확인
    for move in moves:

        # 해당 열을 위에서 아래로 탐색
        for row in range(len(board)):

            # 인형을 발견한 경우
            if board[row][move - 1] != 0:
                doll = board[row][move - 1]

                # 뽑은 자리 비우기
                board[row][move - 1] = 0

                # 바구니 맨 위 인형과 같은 경우
                if stack and stack[-1] == doll:
                    stack.pop()
                    answer += 2

                # 다른 인형이면 바구니에 넣기
                else:
                    stack.append(doll)

                # 인형 하나를 뽑았으므로 해당 열 탐색 종료
                break

    return answer