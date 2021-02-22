# BFS로 풀면될듯
# 가중치없는 최단경로 - BFS 
# BFS : 인접한 노드들부터 탐색하는 탐색알고리즘
# 큐를 사용함.

from collections import deque

N, M = map(int, input().split())

# 방향, 방향은 이런식으로정의하는게 실수가적다.
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

graph = []
for i in range(N):
  graph.append(list(map(int, input())))

def bfs(n, m):
  queue = deque([])
  queue.append([0, 0])

  while queue:
    v = queue.popleft()
    for i in range(len(dx)):
      nx = v[0] + dx[i]
      ny = v[1] + dy[i]
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if graph[nx][ny] == 0 or graph[nx][ny] > 1:
        continue
      else:
        graph[nx][ny] += graph[v[0]][v[1]]
        queue.append([nx, ny])


bfs(N, M)
print(graph[N - 1][M - 1])