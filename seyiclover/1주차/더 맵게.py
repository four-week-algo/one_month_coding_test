# https://school.programmers.co.kr/learn/courses/30/lessons/42626
import heapq as hq

# def solution(scoville, K):
#     cnt = 0

#     # 리스트를 최소 힙으로 변환
#     heapq.heapify(scoville)

#     # 음식이 2개 이상이고, 최솟값이 K보다 작은 동안 반복
#     while len(scoville) >= 2 and scoville[0] < K:

#         # 가장 작은 두 음식 꺼내기
#         first = heapq.heappop(scoville)
#         second = heapq.heappop(scoville)

#         # 새로운 스코빌 지수 계산
#         new = first + second * 2

#         # 다시 힙에 넣기
#         heapq.heappush(scoville, new)

#         cnt += 1

#     # 더 이상 섞을 수 없는데도 K보다 작다면 실패
#     if scoville[0] < K:
#         return -1

#     return cnt

def solution(scoville, K):
    # 힙 자료구조로 변환 
    hq.heapify(scoville)
    cnt = 0
    
    # 힙의 개수가 2개 이상이고 모든 음식의 스코빌 지수가 K 이상이 될 때까지 반복
    while len(scoville) >= 2 and scoville[0] < K:
        # 가장 맵지 않은 음식의 스코빌 지수와 두번째 스코빌 지수 꺼내기
        first = hq.heappop(scoville)
        second = hq.heappop(scoville)
        
        # 스코빌 지수 갱신
        new = first + second * 2
        hq.heappush(scoville, new)
        cnt += 1
    
    # 더 이상 섞을 수 없는데 스코빌 지수가 K보다 작은 경우
    if scoville[0] < K:
        return -1
    
    return cnt