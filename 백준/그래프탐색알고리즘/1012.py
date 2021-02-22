# 유기농 배추
# dfs로 품
# recursion error가떠서 넉넉하게 3000번 재귀호출 가능하게 잡았음.


import sys
sys.setrecursionlimit(3000)

T = int(input())

def dfs(graph, x, y):
  if x < 0 or x >= N or y < 0 or y >= M:
    return False
  if graph[x][y] == 1:
    graph[x][y] = 0
    dfs(graph, x-1, y)
    dfs(graph, x+1, y)
    dfs(graph, x, y-1)
    dfs(graph, x, y+1)

    return True
  return False

for _ in range(T):
  cnt = 0
  M, N, K = map(int, input().split())
  ground = [[0 for _ in range(M)] for _ in range(N)]
  for _ in range(K):
    y, x = map(int, input().split())
    ground[x][y] = 1
  for i in range(N):
    for j in range(M):
      if dfs(ground, i, j) == True:
        cnt += 1
  print(cnt)
