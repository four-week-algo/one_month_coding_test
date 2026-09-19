# https://school.programmers.co.kr/learn/courses/30/lessons/12906
# 원본 배열에서 현재 값과 다음 값을 비교하는 방식
def solution(arr):
    answer = []
    for i in range(len(arr)-1):
        if arr[i] != arr[i+1]:
            answer.append(arr[i])
    answer.append(arr[-1])
    
    return answer

# 스택을 활용한 풀이
def solution(arr):
    result = []
    
    for num in arr:
        if len(result) == 0 or result[-1] != num:
            result.append(num)
        
    return result