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

# dfs는 깊이우선 탐색 알고리즘
# stack을 이용. stack은 재귀함수와동일
# 즉, dfs는 재귀함수를 이용

def dfs(graph, node, visited):
  visited[node] = True
  print(node, end=' ')
  for i in graph[node]:
    if visited[i] == False:
      dfs(graph, i, visited)

dfs(graph, 1, visited)