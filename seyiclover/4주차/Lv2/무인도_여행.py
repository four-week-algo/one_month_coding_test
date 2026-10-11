# https://school.programmers.co.kr/learn/courses/30/lessons/154540
from collections import deque


def solution(maps):
    answer = []

    n = len(maps)
    m = len(maps[0])

    visited = [[False] * m for _ in range(n)]

    dx = [-1, 1, 0, 0]
    dy = [0, 0, -1, 1]

    for x in range(n):
        for y in range(m):

            # 바다가 아니고 아직 방문하지 않은 곳 발견
            if maps[x][y] != "X" and not visited[x][y]:

                queue = deque([(x, y)])
                visited[x][y] = True

                total = 0

                while queue:
                    cx, cy = queue.popleft()

                    # 현재 위치 식량 더하기
                    total += int(maps[cx][cy])

                    # 상하좌우 탐색
                    for i in range(4):
                        nx = cx + dx[i]
                        ny = cy + dy[i]

                        # 지도 범위 확인
                        if 0 <= nx < n and 0 <= ny < m:

                            # 바다가 아니고 방문하지 않았다면
                            if maps[nx][ny] != "X" and not visited[nx][ny]:
                                visited[nx][ny] = True
                                queue.append((nx, ny))

                # 하나의 무인도 탐색 완료
                answer.append(total)

    if not answer:
        return [-1]

    return sorted(answer)