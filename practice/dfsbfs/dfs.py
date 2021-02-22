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

def dfs(graph, start, visited):
  visited[start] = True
  print(start, end=' ')

  for i in graph[start]:
    if visited[i] == False:
      dfs(graph, i, visited)
      # dfs는 이렇게 재귀함수를 이용해 lifo 후입선출, 스택을 구현한다.

dfs(graph, 1, visited)

# dfs는 stack 에 기초하여 탐색하는 그래프 탐색 알고리즘(가장 먼 노드들부터 탐색) 깊이 우선탐색
# depth first search