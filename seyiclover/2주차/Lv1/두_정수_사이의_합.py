# https://school.programmers.co.kr/learn/courses/30/lessons/12912
def solution(a, b):
    answer = 0
    
    if a != b and a < b:
        for i in range(a, b+1):
            answer += i
        return answer
    elif a != b and a > b:
        for i in range(b, a+1):
            answer += i
        return answer
    elif a == b:
        return a