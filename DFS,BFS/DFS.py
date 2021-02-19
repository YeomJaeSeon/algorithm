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
# 그래프의 관계(각 노드가 어느 노드와 연결되어 있는지의 상태를 알려주는 배열)

visited = [False] * 9
# 방문 여부

def dfs(graph, v, visited):
  visited[v] = True
  print(v, end=' ')

  # DFS는 스택자료구조에 기초하므로 재귀함수를 이용할수 있음.
  for i in graph[v]:
    if visited[i] == False:
      dfs(graph, i, visited)

dfs(graph, 1, visited)

# DFS는 스택에 기초하므로 스택과 내부적으로 동일한 재귀함수를 이용하면 깊이우선탐색(탐색 알고리즘) DFS를
# 쉽게 적용할수 있다.