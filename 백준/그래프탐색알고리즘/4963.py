# 입력 없을때까지 입력받기 - EOF에러처리로 해결
import sys
sys.setrecursionlimit(10000)

# 움직이는 8경우
dx = [1,1,0,-1,-1,-1,0,1]
dy = [0,-1,-1,-1,0,1,1,1]

def dfs(x, y, graph):
  if x < 0 or x >= h or y < 0 or y >= w:
    return False
  if graph[x][y] == 1:
    graph[x][y] = 0
    for i in range(8):
      dfs(x + dx[i], y + dy[i], graph)
    return True
  return False
  
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
      if dfs(i, j, graph) == True:
        cnt += 1
  
  print(cnt)
