# https://school.programmers.co.kr/learn/courses/30/lessons/150370
from datetime import datetime

# 날짜를 일단위로 치환하는 함수
def date_transform(date):
    year, month, day = date.split('.')
    return int(year) * 12 * 28 + int(month) * 28 + int(day)


def solution(today, terms, privacies):
    answer = []
    
    # 오늘 날짜를 일단위로 치환
    today_days = date_transform(today)   
    
    # 약관 사전 만들기
    terms_dict = {}
    for term in terms:
        alp, month = term.split()
        terms_dict[alp] = int(month)
        
    # 개인정보 별로 유효기간 계산
    for i, v in enumerate(privacies):
        date, alp = v.split()
        # 날짜를 일단위로 치환
        privacy_days = date_transform(date)
        privacy_days += terms_dict[alp] * 28
        
        # 유효기간 만료 여부 체크
        if privacy_days <= today_days:
            answer.append(i+1)
        
        # print(i, v)
        # print("privacy_days:", privacy_days)
        # print("today_days:", today_days)
    
    return answer