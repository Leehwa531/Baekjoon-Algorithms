#등수 출력

N, K = map(int,input().split())

medals = []

for i in range(N):
  row = list(map(int,input().split()))
  medals.append(row)


#금,은,동이 앞과 같은지 확인
if K > 1 and medals[K-2][1] == medals[K-1][1] and medals[K-2][2] == medals[K-1][2] and medals[K-2][3] == medals[K-1][3]:
  print(K-1)
elif K > 1:
  print(K)