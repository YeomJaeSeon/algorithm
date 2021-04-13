from collections import deque

M, N, K= map(int, input().split())

graph = [[0] * N for i in range(M)] # graph

result = [] # 그래프 방문 결과담을 배열

arr = []
for _ in range(K):
  x1, y1, x2, y2 = map(int, input().split())
  for i in range(x1, x2):
    for j in range(y1, y2):
      graph[j][i] = 1

def bfs(x, y):
  value = 0
  if graph[x][y] == 1:
    return False
  queue = deque()
  queue.append([x,y])
  while queue:
    [a, b] = queue.popleft()
    if a < 0 or a >= M or b < 0 or b >= N:
      continue
    if graph[a][b] == 0:
      value += 1
      graph[a][b] = 1
      queue.append([a - 1, b])
      queue.append([a, b - 1])
      queue.append([a + 1, b])
      queue.append([a, b + 1])
  
  result.append(value)
  return True



cnt = 0
for i in range(M):
  for j in range(N):
    if bfs(i, j) != False:
      cnt += 1

print(cnt)

sortedResult = sorted(result)
for i in range(len(sortedResult)):
  print(sortedResult[i], end=' ')