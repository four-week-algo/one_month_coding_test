# https://school.programmers.co.kr/learn/courses/30/lessons/86491
def solution(sizes):
    answer = 0
    
    # 명함 사이즈에서 긴 부분이 가로, 짧은 부분이 세로가 되도록 정렬
    for i, size in enumerate(sizes):
        size.sort()
        sizes[i] = size
        
    # 가장 긴 가로 길이와 가장 긴 세로 길이 찾기
    height = 0
    width = 0
    for size in sizes:
        if size[0] > height:
            height = size[0]
        if size[1] > width:
            width = size[1]
            
    return height * width