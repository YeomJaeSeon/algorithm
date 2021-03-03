# 2667
import sys
sys.setrecursionlimit(2000)
N = int(input())

graph = []

for _ in range(N):
  info = list(map(int, input()))
  graph.append(info)

arr = []
hounseNum = 0

def dfs(i, j):
  if i < 0 or i >= N or j < 0 or j >= N:
    return False
  if graph[i][j] == 1:
    graph[i][j] += 1
    global hounseNum
    hounseNum += 1
    dfs(i - 1, j)
    dfs(i + 1, j)
    dfs(i, j - 1)
    dfs(i, j + 1)

    return True
  return False

cnt = 0
for i in range(N):
  for j in range(N):
    if dfs(i, j) == True:
      cnt += 1
      arr.append(hounseNum)
      hounseNum = 0

print(cnt)
arr.sort()
for num in arr:
  print(num)
