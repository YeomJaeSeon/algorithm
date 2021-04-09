from collections import deque

graph =[
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

def bfs(graph, startNode, visited):
  queue = deque()
  queue.append(startNode)
  visited[startNode] = True # 방문

  while queue:
    v = queue.popleft()
    print(v, end=' ')
    for i in graph[v]:
      if visited[i] == False: #방문안했어
        queue.append(i)
        visited[i] = True
    

bfs(graph, 1, visited)