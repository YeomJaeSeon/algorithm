from collections import deque

M, N = map(int, input().split())
# M은 가로, N은 세로

graph = []
for _ in range(N):
  graph.append(list(map(int, input().split())))

익은토마토들=[]

for i in range(N):
  for j in range(M):
    if graph[i][j] == 1:
      익은토마토들.append(deque[i, j])

print(익은토마토들)
# def bfs(graph, 익은토마토들):
#   for i in 익은토마토들:
#     queue = deque([])
