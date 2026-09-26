# https://school.programmers.co.kr/learn/courses/30/lessons/12935
def solution(arr):
    min_num = min(arr)
    arr.remove(min_num)

    if not arr:
        return [-1]

    return arr