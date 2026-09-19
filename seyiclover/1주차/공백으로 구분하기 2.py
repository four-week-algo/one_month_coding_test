# https://school.programmers.co.kr/learn/courses/30/lessons/181868
def solution(my_string):
    answer = []
    my_string = my_string.strip().split(' ')
    for string in my_string:
        if string != "":
            answer.append(string)
    return answer