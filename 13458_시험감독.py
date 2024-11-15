from math import ceil

# 시험장의 개수 입력
N = int(input())

# 각 시험장의 응시자 수 입력
A = list(map(int, input().split()))

# 총감독관과 부감독관의 감시 가능 인원 입력
B, C = map(int, input().split())

# 총 감독관 수 계산
count = 0
for i in range(N):
    # 총감독관이 감시할 수 있는 인원 처리
    if A[i] - B > 0:
        나머지 = A[i] - B
        count += ceil(나머지 / C) + 1  # 총감독관 + 부감독관 수 계산
    else:
        count += 1  # 총감독관만 필요한 경우

print(count)
