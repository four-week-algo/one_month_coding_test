# https://school.programmers.co.kr/learn/courses/30/lessons/42576
def solution(participant, completion):
    people = {}
    
    # 참가자 명단 등록
    for person in participant:
        if person in people:
            people[person] += 1
        else:
            people[person] = 1
    
    # 완주자 빼기
    for person in completion:
        people[person] -= 1
        
    # 미완주자 찾기
    for person in people:
        if people[person] > 0:
            return person