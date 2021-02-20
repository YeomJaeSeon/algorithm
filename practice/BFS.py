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
  visited[start] = True
  queue = deque([start])

  while queue:
    v = queue.popleft()
    print(v, end=' ')
    for i in graph[v]:
      if visited[i] == False:
        visited[i] = True
        queue.append(i)

bfs(graph, 1, visited)

# 너비우선 탐색
# 가까운 노드부터 방문
# 가중치없는 간선..인 그래프 에서 최단경로를 묻는 문제로 자주나옴
# 최단경로인 이유는 가장 가까운 노드들부터 탐색하기때문
# dfs는 가장 먼 노드들부터 탐색하므로 최단경로로는 적절치 못하다
# 자료구조 queue를 이용
# 방문처리 append
# 방문하면 popleft를한다