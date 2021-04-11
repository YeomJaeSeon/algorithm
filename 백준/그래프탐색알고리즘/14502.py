from itertools import combinations
import copy
from collections import deque

N, M = map(int, input().split())
graph = []
for i in range(N):
  graph.append(list(map(int, input().split())))

possiblePos=[]
# 벽을 세개만 세움.
for i in range(N):
  for j in range(M):
    if graph[i][j] == 0:
      possiblePos.append([i, j])

virus = []

for i in range(N):
  for j in range(M):
    if graph[i][j] == 2:
      virus.append([i, j])
dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs(graph):
  queue = deque()
  for i in virus:
    queue.append(i)
  while queue:
    [x, y] = queue.popleft()
    for i in range(4):
      nextX = x + dx[i]
      nextY = y + dy[i]
      if nextX < 0 or nextX >= N or nextY < 0 or nextY >= M:
        continue
      if graph[nextX][nextY] == 0:
        graph[nextX][nextY] = 2
        queue.append([nextX, nextY])


# 벽을 세울수있는 경우의수.
maxCnt = 0
for i in combinations(possiblePos, 3):
  copyArr = copy.deepcopy(graph)
  for k in range(3):
    copyArr[i[k][0]][i[k][1]] = 1
  # 벽을 세개 세우는 매경우임.
  bfs(copyArr)
  cnt = 0
  for i in range(N):
    for j in range(M):
      if copyArr[i][j] == 0:
        cnt += 1
  if cnt > maxCnt:
    maxCnt = cnt

print(maxCnt)
  

# 문제의 흐름
# 먼저생각해야할것. 벽세개가 존재할 조합. 경우의수를 combination 를 이용함.
# 애초에 입력되는 가로와 세로가 작음

# 조합을 통해서 모든 벽이존재할경우의수에 대해서 BFS로 너비우선탐색(큐)를이용해서
# 바이러스의 움직임(BFS로 구현)에대해서 0이면 2로 가지못하면(큐가 비면) 그래프탐색종료로
# 매번 0의 개수. 즉 안전한 영역의 개수를 구하고 maxCnt를 통해서 최대값을 도출해냄.