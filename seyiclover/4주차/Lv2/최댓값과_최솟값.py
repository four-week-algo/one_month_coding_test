# https://school.programmers.co.kr/learn/courses/30/lessons/12939
def solution(s):
    numbers = list(map(int, s.split()))

    min_num = min(numbers)
    max_num = max(numbers)

    return str(min_num) + " " + str(max_num)