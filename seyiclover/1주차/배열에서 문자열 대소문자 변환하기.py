# https://school.programmers.co.kr/learn/courses/30/lessons/181875
def solution(strArr):
    answer = []
    for i, word in enumerate(strArr):
        if i % 2 != 0:
            answer.append(word.upper())
        else:
            answer.append(word.lower())
    return answer