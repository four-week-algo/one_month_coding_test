'''
숫자를 반영한 정렬 기능 ?

- 대소문자, 숫자, 공백(" "), 마침표(","), 빼기('-')
- 영문자로 시작
- 숫자 하나 이상 포함
- HEAD, NUMBER, TAIL 세 부분으로 구성됨
- HEAD; 대소문자 구별X

1) 세 부분으로 쪼갠 후
2) 소문자, int 등으로 변환하고
3) 정렬을 시도하되, 기존 idx까지 가지고 있어야 함


단, TAIL은 정렬의 대상이 되면 안된다. 

'''
NUMBER_LIST = list('0123456789')

def solution(files):
    answer = []
    
    # [HEAD, NUMBER] 반환
    def extract(name):
        head, number = '', ''
        
        idx = 0
        while True:
            if idx == len(name):
                break
            if name[idx] in NUMBER_LIST:
                break
            head += name[idx]
            idx += 1
        
        for i in range(idx, idx + 5):
            if i >= len(name):
                break
            
            if name[i] not in NUMBER_LIST:
                break
            number += name[i]
        
        return [head.lower(), int(number)]
        
    # 필요한 것 : [원문 값, 변환된 값 (HEAD + NUMBER), 기존 순서(idx)]
    stack = []
    for idx, file in enumerate(files):
        head, number = extract(file)
        stack.append([file, head, number, idx])
    
    stack = sorted(stack, key = lambda x: [x[1], x[2], x[3]])
    
    return [key[0] for key in stack]
