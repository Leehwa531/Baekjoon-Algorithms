#거리두면서 앉았을 때 최대로 앉을 수 있는 사람 수 알고리즘

from math import ceil

#입력값 받기
H,W,N,M = map(int,input().split())

#가로행  사람 수
rows = ceil(W/(M+1))
#세로열 사람 수
cols = ceil(H/(N+1))

#가로*세로 가 총 앉을 수 있는 사람 수
print(rows * cols)

