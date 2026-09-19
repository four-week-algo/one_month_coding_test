# https://school.programmers.co.kr/learn/courses/30/lessons/1845
def solution(nums):
#     n = len(nums) // 2
    
#     # 포켓몬 중복 제거
#     pokemons = set(nums)
    
#     return len(pokemons) if n > len(pokemons) else n

    return min(len(nums) // 2, len(set(nums)))