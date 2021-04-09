import sys
from collections import deque

n = int(sys.stdin.readline().rstrip())
m = int(sys.stdin.readline().rstrip())

arr = []
for i in range(m):
  arr.append(list(map(int, input().split())))

graph = [[] for _ in range(n + 1)]

# 인접 리스트 행렬로 변경
for i in range(m):
  checkNum1 = arr[i][0]
  if arr[i][1] not in graph[checkNum1]:
    graph[checkNum1].append(arr[i][1])

  checkNum2 = arr[i][1]
  if arr[i][0] not in graph[checkNum2]:
    graph[checkNum2].append(arr[i][0])

visited = [0] * (n + 1)

def bfs(graph, personNum):
  queue = deque()
  queue.append(personNum)
  visited[personNum] += 1

  while queue:
    v = queue.popleft()
    for i in graph[v]:
      if visited[i] == 0:
        visited[i] = visited[v] + 1 # 이번에 방문하는사람은 pop한 visited값에 +1을해줌
        queue.append(i)

bfs(graph, 1)

invitePeople = 0

for i in range(len(visited)):
  if visited[i] == 2 or visited[i] == 3:
    invitePeople += 1

print(invitePeople) # 0과 나자신 뺌