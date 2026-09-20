'''
- 출차된 내역이 없다면 23:59에 출차된 것으로 간주

차량 번호가 작은 자동차부터 fee 배열을 return

'''
from collections import defaultdict
import math

def solution(fees, records):
    
    # 문자열의 시간 형식 -> minute 정수
    def toMinutes(time):
        hour, minute = time.split(':')
        hour, minute = int(hour), int(minute)
        return hour * 60 + minute
    
    # 주차요금 계산기 
    def calculate(arr, fees):
        time_sum = 0
        if len(arr) % 2 == 0: # 마지막 출차기록까지 있는 경우
            for i in range(0, len(arr), 2):
                time_sum += arr[i + 1] - arr[i]
                
        else:
            for i in range(0, len(arr) - 1, 2):
                time_sum += arr[i + 1] - arr[i]
            time_sum += (24 * 60 - 1) - arr[-1]
        
        # fees; [기본시간, 기본요금, 단위시간, 단위요금]
        base_time, base_fee, unit_time, unit_fee = fees

        if time_sum <= base_time:
            return base_fee
        
        return base_fee + math.ceil((time_sum - base_time) / unit_time) * unit_fee
        
        
    answer = []
    # { key : time_list }
    car_dict = defaultdict(list)
    car_set = set()
    
    for record in records:
        time, car_no, _ = record.split()
        time = toMinutes(time)
        car_dict[car_no].append(time)
    
    for car_no in sorted(car_dict):
        fee = calculate(car_dict[car_no], fees)
        answer.append(fee)
    
    return answer
