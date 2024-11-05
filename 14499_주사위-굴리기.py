# 입력 받기
N, M, x, y, K = map(int, input().split())
grid = [list(map(int, input().split())) for _ in range(N)]
commands = list(map(int, input().split()))

# 주사위 초기 상태
dice = [0] * 6  # [윗면, 북쪽, 동쪽, 서쪽, 남쪽, 바닥]

# 이동 방향 정의: 동, 서, 북, 남
directions = [(0, 1), (0, -1), (-1, 0), (1, 0)]

# 주사위 굴리기 함수
def roll_dice(direction):
    top, north, east, west, south, bottom = dice
    if direction == 1:  # 동쪽
        dice[0], dice[2], dice[3], dice[5] = west, top, bottom, east
    elif direction == 2:  # 서쪽
        dice[0], dice[2], dice[3], dice[5] = east, bottom, top, west
    elif direction == 3:  # 북쪽
        dice[0], dice[1], dice[4], dice[5] = south, top, bottom, north
    elif direction == 4:  # 남쪽
        dice[0], dice[1], dice[4], dice[5] = north, bottom, top, south

# 명령 처리
for command in commands:
    dx, dy = directions[command - 1]
    nx, ny = x + dx, y + dy

    # 지도 범위 안에서만 이동
    if 0 <= nx < N and 0 <= ny < M:
        x, y = nx, ny
        roll_dice(command)

        # 지도와 주사위의 바닥면 처리
        if grid[x][y] == 0:
            grid[x][y] = dice[5]  # 주사위 바닥면의 값 복사
        else:
            dice[5] = grid[x][y]  # 지도의 값을 주사위 바닥면에 복사
            grid[x][y] = 0  # 지도 칸의 값은 0으로

        # 주사위 윗면 값 출력
        print(dice[0])
