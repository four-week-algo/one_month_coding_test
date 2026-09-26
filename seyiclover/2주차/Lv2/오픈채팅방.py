# https://school.programmers.co.kr/learn/courses/30/lessons/42888
def solution(record):
    answer = []
    nickname = {}

    # 1. 최종 닉네임 저장
    for r in record:
        data = r.split()

        command = data[0]
        uid = data[1]

        if command == "Enter" or command == "Change":
            name = data[2]
            nickname[uid] = name

    # 2. 최종 닉네임을 이용해서 메시지 생성
    for r in record:
        data = r.split()

        command = data[0]
        uid = data[1]

        if command == "Enter":
            answer.append(nickname[uid] + "님이 들어왔습니다.")

        elif command == "Leave":
            answer.append(nickname[uid] + "님이 나갔습니다.")

    return answer