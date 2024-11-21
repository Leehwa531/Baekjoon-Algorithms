def cal(alst, blst):
    asm = bsm = 0
    for i in range(M):
        for j in range(M):
            asm += arr[alst[i]][alst[j]]
            bsm += arr[blst[i]][blst[j]]
    return abs(asm - bsm)

def dfs(n, alst, blst):
    global ans
    if n == N:
        if len(alst) == len(blst):  # A팀과 B팀의 크기가 같을 경우에만
            ans = min(ans, cal(alst, blst))  # 능력치 차이의 최솟값 갱신
        return
    
    # A팀에 추가
    dfs(n + 1, alst + [n], blst)  
    # B팀에 추가
    dfs(n + 1, alst, blst + [n])  

N = int(input())  # 사람 수
arr = [list(map(int, input().split())) for _ in range(N)]  # 능력치 배열
M = N // 2  # 한 팀의 인원 수

ans = 100 * M * M  # 최솟값 갱신을 위한 초기값

dfs(0, [], [])  # 백트래킹 시작

print(ans)  # 결과 출력
