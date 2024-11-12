total_people = int(input())  # 사람 수 입력
people = []  # 각 사람의 (몸무게, 키) 정보를 담을 리스트

# 각 사람의 몸무게와 키를 입력받아 저장
for _ in range(total_people):
    x, y = map(int, input().split())
    people.append((x, y))

# 각 사람의 덩치 등수를 계산하여 저장
ranks = []  # 최종 등수를 저장할 리스트
for i in range(total_people):
    rank = 1  # 기본 등수는 1등으로 시작
    for j in range(total_people):
        if i != j and people[i][0] < people[j][0] and people[i][1] < people[j][1]:
            rank += 1  # 자신보다 큰 덩치를 가진 사람이 있으면 등수 증가
    ranks.append(rank)  # 계산한 등수를 리스트에 추가

# 결과 출력
print(*ranks)  # 공백으로 구분하여 등수 출력