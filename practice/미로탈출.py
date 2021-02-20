from collections import deque

n, m = map(int, input().split())

graph = []
for _ in range(n):
  graph.append(list(map(int, input())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(x, y):
  queue = deque([[x, y]])

  while queue:
    currentX, currentY = queue.popleft()
    for i in range(4):
      nx = currentX + dx[i]
      ny = currentY + dy[i]

      if nx < 0 or nx >= n or ny < 0 or ny >= m:
        continue
      if graph[nx][ny] == 0:
        continue
      if graph[nx][ny] == 1:
        graph[nx][ny] = graph[currentX][currentY] + 1
        queue.append([nx, ny])

  return graph[n - 1][m - 1]


print(bfs(0, 0))

# bfs는 너비우선 탐색 - 가까운 노드들부터 방문 - 큐를 이용.
# 그러므로 최단경로 (가중치없는 그래프에서)를 묻는 문제에서 자주 출제된다.