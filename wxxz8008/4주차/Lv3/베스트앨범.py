'''
장르 별로 가장 많이 재생된 노래 "두 개씩"

우선순위: 장르 재생 수 > 노래 재생 수 > 장르와 재생 수 모두 같으면 고유번호 낮은 순

genres; 노래 장르
plays; 노래별 재생 횟수


<필요한 것>
(genre, play, idx)
genre-sum(play)를 key-value로 가지는 dict 생성 => value 기준으로 정렬을 해야함

1. genre별로 sum 집계
2. 

'''
from collections import defaultdict
def solution(genres, plays):
    
    genre_dict = defaultdict(int)
    for idx, genre in enumerate(genres):
        genre_dict[genre] += plays[idx]
    
    # dict.items()를 통해 [(key1, value1), (key2, value2)..] 형식을 만들 수 있음
    # genre_dict = sorted(genre_dict.items(), key=lambda x: x[1], reverse=True)

    # print(genre_dict)
    
    # (genre, play, idx)를 원소로 갖는 배열 만들기 
    music = []
    for idx, genre in enumerate(genres):
        music.append((genre_dict[genre], plays[idx], idx, genre)) # 마지막에 cnt 세기 위해 gerne도 같이 담음
    
    cnt = defaultdict(int) # 2번을 넘지 않도록
    # music 배열 정렬 후 결과 추출
    # 우선순위: play 큰 순 > idx 작은 순 
    music = sorted(music, key=lambda x: [-x[0], -x[1], x[2]])
    
    answer = []
    for total_play, play, idx, genre in music:
        if cnt[genre] < 2:
            cnt[genre] += 1
            answer.append(idx)    
    
    return answer
