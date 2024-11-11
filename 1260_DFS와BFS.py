#0. 순서
#1. 값 입력받기
#2. 그래프 방문 리스트 초기화
#3. DFS -> 재귀함수
#4. BFS -> 덱
#5. 출력

#BFS에 쓸 덱 임포트
from collections import deque


#정점의 개수, 간선의 개수, 정점 번호 입력받기
N,M,V = map(int,input().split())

#그래프 생성
graph = [[0]*(N+1) for _ in range(N+1)]

#인접행렬로 간선값 입력받기
for i in range(M):
  x,y = map(int,input().split())
  graph[x][y] = 1
  graph[y][x] = 1

#방문 리스트 생성
visited1 = [0]*(N+1)
visited2 = [0]*(N+1)

def dfs(V):
  #노드 방문 처리
  visited1[V] = 1
  #방문한 노드 출력
  print(V, end=" ")

  for i in range(1,N+1):
    if not visited1[i] and graph[V][i] == 1:
      dfs(i)

def bfs(V):
  q = deque([V])

  #노드 방문 처리
  visited2[V] = 1

  while q:
    #방문한 노드 출력
    V = q.popleft()
    #맨앞 큐 스택 출력
    print(V,end=" ")

    for i in range(1,N+1):
      if not visited2[i] and graph[V][i] == 1:
        #방문하지 않았고 인접행렬 1값이면 큐에 추가
        q.append(i)
        visited2[i] = 1
dfs(V)
print()
bfs(V)


# DFS : 스택과 재귀함수로 구현.
# BFS : deque, while로 구현.
