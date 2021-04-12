# 입력 없을때까지 입력받기 - EOF에러처리로 해결
from collections import deque

# 움직이는 8경우
dx = [1,1,0,-1,-1,-1,0,1]
dy = [0,-1,-1,-1,0,1,1,1]

def bfs(x, y, graph):
  queue = deque()
  queue.append([x, y])
  # 바다거나 이미 방문했거나 하면 False를 리턴. -> BFS는 요런식으로
  if graph[x][y] == 0:
    return False
  while queue:
    [a, b] = queue.popleft()
    if graph[a][b] == 1:
      graph[a][b] = 0
      for i in range(8):
        nextX = a + dx[i]
        nextY = b + dy[i]
        if nextX < 0 or nextX >= h or nextY < 0 or nextY >= w:
          continue
        queue.append([nextX, nextY])
  
  return True

  # if x < 0 or x >= h or y < 0 or y >= w:
  #   return False
  # if graph[x][y] == 1:
  #   graph[x][y] = 0
  #   for i in range(8):
  #     dfs(x + dx[i], y + dy[i], graph)
  #   return True
  # return False
  
while True:
  w, h = map(int, input().split())
  if w == 0 and h == 0:
    break
  graph = []
  for _ in range(h):
    graph.append(list(map(int, input().split())))
  
  # print(graph)
  cnt = 0
  for i in range(h):
    for j in range(w):
      if bfs(i, j, graph) == True:
        cnt += 1
  
  print(cnt)


# queue를 이용한 BFS로 문제품