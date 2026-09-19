# https://school.programmers.co.kr/learn/courses/30/lessons/42748
def solution(array, commands):
    answer = []
    
    for command in commands:
        # i, j, k 변수 할당
        i = command[0]
        j = command[1]
        k = command[2]

        # array 자르기
        array_cut = array[i-1:j]

        # 정렬
        array_cut = sorted(array_cut)
        answer.append(array_cut[k-1])
        
    return answer