def dfs(idx, current, add, sub, mul, div):
    global max_value, min_value

    if idx == N:  # 모든 숫자를 사용한 경우
        max_value = max(max_value, current)
        min_value = min(min_value, current)
        return

    if add > 0:
        dfs(idx + 1, current + array[idx], add - 1, sub, mul, div)
    if sub > 0:
        dfs(idx + 1, current - array[idx], add, sub - 1, mul, div)
    if mul > 0:
        dfs(idx + 1, current * array[idx], add, sub, mul - 1, div)
    if div > 0:
        if current < 0:
            dfs(idx + 1, -(abs(current) // array[idx]), add, sub, mul, div - 1)
        else:
            dfs(idx + 1, current // array[idx], add, sub, mul, div - 1)


# 입력 처리
N = int(input())
array = list(map(int, input().split()))
add, sub, mul, div = map(int, input().split())

# 최댓값과 최솟값 초기화
max_value = -10**9
min_value = 10**9

# DFS 시작
dfs(1, array[0], add, sub, mul, div)

# 결과 출력
print(max_value)
print(min_value)
