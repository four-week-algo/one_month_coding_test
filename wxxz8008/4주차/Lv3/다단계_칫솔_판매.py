'''
https://school.programmers.co.kr/learn/courses/30/lessons/77486

자신의 추천인에 연결되어 피라미드 구성.

- 10%를 추천인에게 줘야함
- 10%는 원단위에서 절삭 => 절삭된 건 90%에 포함된
- 10원 미만인 경우는 분배하지 않음
- 칫솔 1개 이익 = 100원

enrolls; 참여자
referrals; 나의 추천인

자신의 추천인을 가리키는 dict
자신의 이익를 저장하는 dict

자신의 부모가 '-'이라면 종료 준비해야함
center의 이익은 return하지 않아도 됨

'''
def solution(enrolls, referrals, sellers, amount):
    answer = []
    
    referral_dict = dict() # value에 자신의 추천인이 저장된   
    share_dict = dict() # 자신의 이익이 저장됨
    
    for i in range(len(enrolls)):
        referral_dict[enrolls[i]] = referrals[i]
        share_dict[enrolls[i]] = 0
        
    # 이익 분배 시작
    for i in range(len(sellers)):
        seller = sellers[i]
        
        share = amount[i] * 100 # 이 share를 나누어 가져야 함
        while seller != '-': # center의 몫까진 구할 필요 없으므로
            
            # share_10 = share // 10 # 부모로 보내야 함 
            # share_90 = share - (share // 10) 
            
            share_dict[seller] += share - (share // 10) # 당장 누적해도 됨
            share = share // 10 # 부모로 보내야 함
            
            if not share:
                break
            
            seller = referral_dict[seller] # 부모가 다시 seller가 됨
    
    for enroll in enrolls:
        answer.append(share_dict[enroll])
        
    return answer
