P = int(input())  # 테스트 케이스 수
for _ in range(P):
    test_case = list(map(int, input().split()))  # 테스트 케이스 번호와 20명의 키
    T = test_case[0]  # 테스트 케이스 번호
    heights = test_case[1:]  # 20명의 키

    # 학생들이 서 있을 줄
    line = []

    # 뒤로 물러난 걸음 수 총합
    total_steps = 0

    for height in heights:
        steps = 0
        # 현재 키보다 큰 학생을 찾아서 그 앞에 세운다
        for i in range(len(line)):
            if line[i] > height:
                steps += 1
        line.insert(len(line) - steps, height)
        total_steps += steps

    print(T, total_steps)
