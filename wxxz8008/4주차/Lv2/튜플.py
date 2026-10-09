'''
https://school.programmers.co.kr/learn/courses/30/lessons/64065

- 원소의 개수 n개
- 중복되는 원소가 없음

그냥 제일 긴 원소 뽑아내면 되는 문제
stack으로 충분히 풀 수 있을 듯

'''


def solution(s):
    answer = []
    
    s = s[1:-1] # 가장 겉의 {} 제외하기
    stack = [] # 여러 수의 모음
    val = '' # 개별 수의 값
    answer = []
        
    for char in s:
        if char == '{':
            stack = []
            val = ''
        elif char == '}':
            stack.append(val)
            answer.append(stack)
            stack = []
            val = ''
        elif char == ',':
            stack.append(val)
            val = ''
        else: # 숫자일 때
            val += char
     
    result = []
    answer.sort(key = lambda x: len(x))
    for i in range(len(answer), 1, -1):
        for val in answer[i - 1]:
            if val not in answer[i - 2]:
                result.append(val)
                
    result.append(answer[0][0])
    result = [int(val) for val in result][::-1]


    return result
