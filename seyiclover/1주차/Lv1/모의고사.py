# https://school.programmers.co.kr/learn/courses/30/lessons/42840
def solution(answers):
    result = []
    score_1 = score_2 = score_3 = 0
    
    # 수포자의 답안
    first = [1, 2, 3, 4, 5]
    second = [2, 1, 2, 3, 2, 4, 2, 5]
    third = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5]
    
    # 정답과 대조
    for i, answer in enumerate(answers):
        if answer == first[i % len(first)]:
            score_1 += 1
        if answer == second[i % len(second)]:
            score_2 += 1
        if answer == third[i % len(third)]:
            score_3 += 1
            
    # 최다 득점
    max_score = max(score_1, score_2, score_3)
    
    # 최다 득점자
    if max_score == score_1:
        result.append(1)
    if max_score == score_2:
        result.append(2)
    if max_score == score_3:
        result.append(3)
    
    return result