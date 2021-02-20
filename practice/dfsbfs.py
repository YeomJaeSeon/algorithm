# DFS
# 탐색문제다. 그런데 상하좌우 이렇게 밖에 못움직인데.. 그럼 노드들간의 간선으로 표현가능하겠네
# 그럼 그래프 탐색으로 풀수 있겠다.
# DFS, BFS 중 하나 사용
# DFS는 멀리있는 노드들부터 , BFS는 가까운 노드들 부터 탐색
# DFS는 스택(재귀함수), BFS는 큐로 풀수있음

from collections import deque
# DFS
graph = [
  [],
  [2, 3],
  [1, 7, 8],
  [1, 4, 5],
  [3],
  [3],
  [7, 8],
  [2, 6, 8],
  [2, 6, 7],
]
# 그래프 관계.

visited = [False] * 9

#방문 여부

# def dfs(graph, node, visited):
#   visited[node] = True

#   print(node, end=' ')
#   for i in graph[node]:
#     if visited[i] == False:
#       dfs(graph, i, visited)

# dfs(graph, 1, visited)

# BFS는 가중치없는 그래프 에서 최단경로 찾는데 용이한 알고리즘
# 가장가까운 노드들부터(인접한 노드) 방문하기 때문이지..

def bfs(graph, node, visited):
  queue = deque([node])

  while queue:
    v = queue.popleft()
    visited[v] = True
    print(v, end=' ')
    
    for i in graph[v]:
      if visited[i] == False:
        visited[i] = True
        queue.append(i)

bfs(graph, 1, visited)
