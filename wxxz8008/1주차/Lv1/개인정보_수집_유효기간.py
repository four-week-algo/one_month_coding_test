'''
n; 개인정보의 개수
유효기간이 지났다면 파기 대상.

endDt가 today보다 이전이라면 파기 대상. (endDt == today는 파기 X)

** 모든 달은 28일까지 있다고 가정 **

'''

def solution(today, terms, privacies):
    
    # 만료 대상이라면 True return 
    # endDt가 today보다 이전이라면 파기 대상
    def judge(t_year, t_month, t_day, year, month, day):
        if year * 28 * 28 + month * 28 + day < t_year * 28 * 28 + t_month * 28 + t_day:
            return True
        return False
        
    answer = []
    
    t_year, t_month, t_day = today.split('.')
    t_year, t_month, t_day = int(t_year), int(t_month), int(t_day)
    td = dict()
    for term in terms:
        a, b = term.split()
        td[a] = int(b)
    
    for idx, privacy in enumerate(privacies):
        date, rule = privacy.split()
        year, month, day = date.split('.')
        year, month, day = int(year), int(month), int(day)
        
        month += td[rule]
        
        while month > 12:
            month -= 12
            year += 1
        
        # endDt를 만들려면 하루를 더 빼줘야 함
        if day != 1:
            day -= 1
        else: # day == 1
            if month != 1:
                day = 28
                month -= 1 
            else: # month == 1
                year -= 1
                month, day = 12, 28
        
        if judge(t_year, t_month, t_day, year, month, day):
            answer.append(idx + 1)
    
    return answer
