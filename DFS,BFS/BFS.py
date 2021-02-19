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

def bfs(graph, start, visited):
  queue = deque([start])
  # python에서 큐를 이용하려면 deque 라이브러리를 이용.

  visited[start] = True
  while queue:
    v = queue.popleft()
    # 큐에서 pop하는 메소드
    print(v, end=' ')

    for i in graph[v]:
      if visited[i] == False:
        queue.append(i)
        visited[i] = True

bfs(graph, 1, visited)