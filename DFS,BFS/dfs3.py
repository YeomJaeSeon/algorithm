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

#dfs

def dfs(graph, visited, startNode):
  visited[startNode] = True
  print(startNode, end=' ')
  
  for i in graph[startNode]:
    if visited[i] == False:
      dfs(graph, visited, i)

dfs(graph, visited, 1)