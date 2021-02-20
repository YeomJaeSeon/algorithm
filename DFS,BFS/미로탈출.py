# bfs는 가중치가 같은 간선들이 있는 그래프에서 최단경로를 찾는데 좋다.
# 처음엔 왜그러는지 이해안됐는데.. bfs가 가까운 노드들부터 탐색하기 때문에
# 당연한 것이다..
# dfs는 멀리있는 노드들부터 탐색하므로 최단경로와는 거리가 멀다.. 하나의 깊이를 잘 골라야하므로

from collections import deque

n, m = map(int,input().split())

graph = []
for _ in range(n):
  graph.append(list(map(int, input())))

# 방향
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(graph, start):
  queue = deque([[start, start]])
  while queue:
    # 현재 위치
    x, y = queue.popleft()
    # 네방향 탐색 (bfs로)
    for i in range(4):
      nx = x + dx[i]
      ny = y + dy[i]
      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if graph[nx][ny] == 0:
        continue
      if graph[nx][ny] == 1:
        graph[nx][ny] = graph[x][y] + 1
        queue.append([nx, ny])
  return graph[n - 1][m - 1]


print(bfs(graph, 0))

# from collections import deque

# queue = deque([[1, 3]])
# queue.append([2, 4])
# print(queue)