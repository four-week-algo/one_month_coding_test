# https://school.programmers.co.kr/learn/courses/30/lessons/43238
def solution(n, times):
    left = 1
    right = max(times) * n

    answer = right

    while left <= right:
        mid = (left + right) // 2

        # mid분 동안 심사할 수 있는 사람 수
        people = 0

        for time in times:
            people += mid // time

        # n명을 처리하기에 시간이 부족
        if people < n:
            left = mid + 1

        # n명 이상 처리 가능
        else:
            answer = mid

            # 더 짧은 시간도 가능한지 탐색
            right = mid - 1

    return answer