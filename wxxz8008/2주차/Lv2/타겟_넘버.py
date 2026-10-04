'''
n개 정수 (num >= 0)

2 ** 20 ~= 1_000_000 => 시간복잡도 OK

'''

ans = 0
def solution(numbers, target):
    
    def go(idx, sum_val):
        global ans
        if idx == n:
            if sum_val == target:
                ans += 1
            return
        go(idx + 1, sum_val + numbers[idx])
        go(idx + 1, sum_val - numbers[idx])
    
    n = len(numbers)
    go(0, 0)
    
    
    return ans
