import sys
from collections import deque

N, M = map(int, sys.stdin.readline().rstrip().split())

graph = []
for i in range(N):
  graph.append(list(map(int, sys.stdin.readline().rstrip())))

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(graph, x, y):
  queue = deque()
  queue.append([x, y])
  
  while queue:
    [a, b] = queue.popleft()
    for i in range(4):
      moveX = a + dx[i]
      moveY = b + dy[i]
      if moveX < 0 or moveX >= N or moveY < 0 or moveY >= M:
        continue
      if graph[moveX][moveY] == 1:
        continue
  
  return True

cnt = 0
for i in range(M):
  for j in range(N):
    if bfs(graph, i, j) == True:
      cnt += 1

print(cnt)