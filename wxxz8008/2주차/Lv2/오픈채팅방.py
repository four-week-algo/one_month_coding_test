'''
https://school.programmers.co.kr/learn/courses/30/lessons/42888

<닉네임 변경 방법>
1. 나간 후 다시 들어옴
2. 닉네임 변경

- 닉네임 변경하면 기존 채팅방의 출력 내용도 모두 변경됨
- 중복 닉네임 허용

Enter, Leave, Change; 최종 닉네임만 기억하고 있으면 되는 것 아닌가?
-> Leave는 사실상 필요 없음 (단 원소배열의 길이가 다름)
- 

최종 변경 반영된 배열 return

'''

# records; 변경 기록이 담긴 배열
def solution(records):
    
    answer = []
    d = dict()
    
    # 1. records : dict에 key 저장하기
    for record in records:
        if record[:5] == 'Leave': # Leave
            continue
        order, id, nickname = record.split()
        
        d[id] = nickname
    
    # 2. records 정방향으로 result 출력하기
    for record in records:
        if record[:6] == 'Change':
            continue
            
        if record[:5] == 'Leave':
            _, id = record.split()
            answer.append(d[id] + "님이 나갔습니다.")
        # Enter
        else:
            _, id, nickname = record.split()
            answer.append(d[id] + "님이 들어왔습니다.")

    return answer
