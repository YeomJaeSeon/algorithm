from collections import deque

M, N = map(int, input().split())
# M은 가로 N은 세로

graph = []
for _ in range(N):
  graph.append(list(map(int, input().split())))

tomatoes = deque([])

for i in range(N):
  for j in range(M):
    if graph[i][j] == 1:
      tomatoes.append([i, j])

dx = [-1, 1, 0, 0]
dy = [0, 0, -1, 1]

def bfs():
  days = 0

  while tomatoes:
    v = tomatoes.popleft()

    curX = v[0]
    curY = v[1]

    for i in range(4):
      nx = curX + dx[i]
      ny = curY + dy[i]

      if nx < 0 or nx >= N or ny < 0 or ny >= M:
        continue
      if graph[nx][ny] == -1:
        continue
      if graph[nx][ny] == 0:
        graph[nx][ny] = graph[curX][curY] + 1
        days = graph[nx][ny]
        tomatoes.append([nx, ny])
    # print('--------------')
    # for i in range(N):
    #   for j in range(M):
    #     print(graph[i][j], end=' ')
    #   print('')
    # print('------------')
        
  return days - 1

start = False
for i in range(N):
  for j in range(M):
    if graph[i][j] == 0:
      start = True
      break

if start == False:
  print(0)
else:
  result = bfs()
  flag = False
  for i in range(N):
    for j in range(M):
      if graph[i][j] == 0:
        flag = True # 다익을순 없다.
        break
  
  if flag == True:
    print(-1)
  else:
    print(result)


