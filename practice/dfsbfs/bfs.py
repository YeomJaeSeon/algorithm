# bfs - Breadth first search
# 너비 우선 탐색. 가까운 노드들부터 탐색.
# DFS와는 다르다.
# 큐를 이용
from collections import deque

graph = [
  [],
  [2, 3, 8],
  [1, 7],
  [1, 4, 5],
  [3, 5],
  [3, 4],
  [7],
  [2, 6, 8],
  [1, 7]
]

visited = [False] * 9
# 방문여부


def bfs(graph, start, visited):
  queue = deque([])
  queue.append(start)
  visited[start] = True
  while queue:
    v = queue.popleft()
    print(v, end=' ')

    for i in graph[v]:
      if visited[i] == False:
        queue.append(i)
        visited[i] = True
        

bfs(graph, 1, visited)