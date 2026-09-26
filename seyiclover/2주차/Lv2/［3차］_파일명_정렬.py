# https://school.programmers.co.kr/learn/courses/30/lessons/17686
def parse_file(file):
    # NUMBER 시작 위치
    number_start = 0

    for i, char in enumerate(file):
        if char.isdigit():
            number_start = i
            break

    # NUMBER 끝 위치
    number_end = number_start

    while (
        number_end < len(file)
        and file[number_end].isdigit()
        and number_end - number_start < 5
    ):
        number_end += 1

    head = file[:number_start]
    number = file[number_start:number_end]

    return head, number


def solution(files):
    return sorted(
        files,
        key=lambda file: (
            parse_file(file)[0].lower(),
            int(parse_file(file)[1])
        )
    )