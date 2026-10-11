# https://school.programmers.co.kr/learn/courses/30/lessons/77486
def solution(enroll, referral, seller, amount):
    parent = {}
    profit = {}

    # 추천인 관계 및 수익 초기화
    for person, ref in zip(enroll, referral):
        parent[person] = ref
        profit[person] = 0

    # 판매 기록 처리
    for person, cnt in zip(seller, amount):

        # 판매 금액
        money = cnt * 100

        # 추천인을 따라 위로 올라가며 분배
        while person != "-" and money > 0:

            # 추천인에게 줄 10%
            commission = money // 10

            # 현재 판매자의 수익
            profit[person] += money - commission

            # 추천인으로 이동
            person = parent[person]
            money = commission

    # enroll 순서대로 수익 반환
    return [profit[person] for person in enroll]