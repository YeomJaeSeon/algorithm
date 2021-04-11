from collections import deque

a, b = map(int, input().split())
graph = [0] * 100001

def bfs(pos):
  queue = deque();
  queue.append(pos)
  while queue:
    v = queue.popleft()
    # print(v, end=' ')
    # 동생을 찾으면
    if v == b:
      return graph[v]
    # 다음으로 이동 : 순간이동하거나 -1, +1로 움직임.
    if 0 < (v * 2) < len(graph):
      if graph[v * 2] == 0:
        queue.append(v * 2)
        graph[v * 2] = graph[v] + 1
    if v - 1 >= 0:
      if graph[v - 1] == 0:
        queue.append(v - 1)
        graph[v - 1] = graph[v] + 1
    if v + 1 < len(graph):
      if graph[v + 1] == 0:
        queue.append(v + 1)
        graph[v + 1] = graph[v] + 1


print(bfs(a))

# BFS로 간단하게 탐색하면서 풀었따.
# 가중치없는 최단거리 - BFS!!
# 헤맸던부분 : 0에서 *2가되면 다시 0인걸 망각함.. 그래서 불필요하게 큐에 하나더쌓여서 
# 잘못된 값이나왔음. *2를 할때 0만 처리해주니 풀림.