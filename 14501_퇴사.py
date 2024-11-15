# 입력 받기
N = int(input())
T = [0] * N
P = [0] * N
for i in range(N):
    T[i], P[i] = map(int, input().split())

# DP 테이블 초기화
dp = [0] * (N + 1)

# 뒤에서 앞으로 DP 계산
for n in range(N - 1, -1, -1):
    if n + T[n] <= N:
        # 상담 가능 기간 내에 완료될 경우
        dp[n] = max(dp[n + 1], dp[n + T[n]] + P[n])
    else:
        # 상담 불가 시 이전 값 유지
        dp[n] = dp[n + 1]

# 결과 출력
print(dp[0])
