from collections import deque

M, N = map(int, input().split())
# M은 가로, N은 세로

graph = []
for _ in range(N):
  graph.append(list(map(int, input().split())))

익은토마토들 = []

for i in range(N):
  for j in range(M):
    if graph[i][j] == 1:
      익은토마토들.append(deque([[i, j]]))
      # 탐색을 시작할 노드들
      # 큐를 집어넣음

# print('익은 놈들: ', 익은토마토들)

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]


def bfs(tomatoes):
  day = 0
  while True:
    empty = 0
    for queue in tomatoes:
      if len(queue) == 0:
        empty += 1
        continue
      v = queue.popleft()
      currentPosX = v[0]
      currentPosY = v[1]

      for i in range(4):
        nx = currentPosX + dx[i]
        ny = currentPosY + dy[i]

        if nx < 0 or nx >= N or ny < 0 or ny >= M:
          continue
        if graph[nx][ny] == -1:
          continue
        if graph[nx][ny] == 0:
          queue.append([nx, ny])
          graph[nx][ny] = graph[currentPosX][currentPosY] + 1
          day = graph[nx][ny]

    # 토마토 익는 상황 그래프로 출력
    # print('--------------')
    # for i in range(N):
    #   for j in range(M):
    #     print(graph[i][j], end=' ')
    #   print('')
    # print('------------')

    if empty == len(tomatoes):
      break;
  return day

start = False
for i in range(N):
  for j in range(M):
    if graph[i][j] == 0:
      start = True
      break;
if start == False:
  print(0)
else:
  result = bfs(익은토마토들) - 1
  # 최소 일수
  flag = False
  for i in range(N):
    for j in range(M):
      if graph[i][j] == 0:
        flag = True
        break;
  if flag == True:
    print(-1)
  else:
    print(result)

