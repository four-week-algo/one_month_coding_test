# https://school.programmers.co.kr/learn/courses/30/lessons/92341
import math

def minute_transform(time):
    hour, minute = time.split(":")
    return int(hour) * 60 + int(minute)


def solution(fees, records):
    records_dict = {}
    answer = []

    # 요금 정보
    basic_time, basic_fee, unit_time, unit_fee = fees

    # 입출차 기록 처리
    for record in records:
        time, car_num, status = record.split()

        # 처음 등장한 차량
        if car_num not in records_dict:
            records_dict[car_num] = {
                "in_time": None,
                "total_time": 0
            }

        if status == "IN":
            records_dict[car_num]["in_time"] = minute_transform(time)

        elif status == "OUT":
            records_dict[car_num]["total_time"] += (
                minute_transform(time)
                - records_dict[car_num]["in_time"]
            )

            # 출차했으므로 현재 주차 중이 아님
            records_dict[car_num]["in_time"] = None

    # 출차 기록이 없는 차량 → 23:59 출차 처리
    end_time = minute_transform("23:59")

    for car_num, value in records_dict.items():
        if value["in_time"] is not None:
            value["total_time"] += end_time - value["in_time"]
            value["in_time"] = None

    # 차량 번호 순서대로 요금 계산
    for car_num in sorted(records_dict):
        total_time = records_dict[car_num]["total_time"]

        # 기본 시간 이하
        if total_time <= basic_time:
            fee = basic_fee

        # 기본 시간 초과
        else:
            extra_time = total_time - basic_time
            fee = basic_fee + math.ceil(extra_time / unit_time) * unit_fee

        answer.append(fee)

    return answer