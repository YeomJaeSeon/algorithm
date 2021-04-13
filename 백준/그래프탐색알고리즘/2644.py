from collections import deque

n = int(input())
targetX, targetY = map(int, input().split())
visited = [0] * (n + 1)

m = int(input())
arr = []
for _ in range(m):
  arr.append(list(map(int, input().split())))

graph = [[]]
for i in range(1, n + 1):
  newArr = []
  for j in arr:
    if j[0] == i:
      newArr.append(j[1])
    if j[1] == i:
      newArr.append(j[0])
  newArr.sort()
  graph.append(newArr)

# bfs시작
queue = deque()
queue.append(targetX)
visited[targetX] = 1

while queue:
  v = queue.popleft()
  for i in graph[v]:
    if visited[i] == 0:
      visited[i] = visited[v] + 1
      queue.append(i)
    
if visited[targetY] == 0:
  print(-1)
else:
  print(visited[targetY] - 1)

# bfs로 그래프탐색함.
# visited를 0으로 모두초기화한다음 거리만큼 + 1함.
# 부모자식관계면 이전촌수에서 +1을함. - 이생각하는게
# 나는 왜이리어려웠을까.. 되게쉬운 생각인데.