N =int(input())
M = int(input())

arr = []
visited = [False] * (N + 1)
for _ in range(M):
  a, b = map(int, input().split())
  arr.append([a, b])
graph = [[]]
for i in range(1, N + 1):
  nodeslist = []
  for info in arr:
    if i == info[0]:
      nodeslist.append(info[1])
    if i == info[1]:
      nodeslist.append(info[0])
  graph.append(nodeslist)


# nodelist는 인접리스트 방식으로 그래프 표현한것임
def dfs(graph, visited, start):
  visited[start] = True

  for i in graph[start]:
    if visited[i] == False:
      dfs(graph, visited, i)



dfs(graph, visited, 1)
cnt = 0
for i in visited:
  if i == True:
    cnt += 1

print(cnt - 1)