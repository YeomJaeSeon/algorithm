from collections import deque

# 첫번째 생각 인접리스트 방식으로 바꾸자(그래프 표현을)

N, M= map(int, input().split())
# 정점과 간선수

base = []
for _ in range(M):
  base.append(list(map(int, input().split())))

graph = [[]]

for i in range(1, N + 1):
  newArr = []
  for info in base:
    if info[0] == i:
      newArr.append(info[1])
    elif info[1] == i:
      newArr.append(info[0])
  sortedArr = sorted(newArr)

  graph.append(sortedArr)

visited = [False for _ in range(N + 1)]

def bfs(graph, start, visited):
  if visited[start] == True:
    return False
  queue = deque([])
  visited[start] = True
  queue.append(start)

  while queue:
    v = queue.popleft()
    for i in graph[v]:
      if visited[i] == False:
        visited[i] = True
        queue.append(i)
  return True

result = 0
for i in range(1, N + 1):
  if bfs(graph, i, visited) == True:
    result += 1

print(result)

