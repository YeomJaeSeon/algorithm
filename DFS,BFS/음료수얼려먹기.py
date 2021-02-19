n, m = map(int, input().split())

graph = []
for _ in range(n):
  graph.append(list(map(int, input())))

# 그래프 탐색을 이용하면되겠다. -bfs dfs중하나로 풀자.
# 방문 한 노드의 개수를 구하면되겠다.
# 0은 방문가능하게, 0인 노드의 상하좌우도 dfs나 bfs로 그래프 탐색

def dfs(x, y):
  if x < 0 or x >= n or y < 0 or y >= m:
    return False
  if graph[x][y] == 0:
    graph[x][y] = 1
    dfs(x - 1, y)
    dfs(x, y + 1)
    dfs(x, y - 1)
    dfs(x + 1, y)
    # 위 네개의 재귀함수는 뭔가를 리턴하는게 아닌 방문처리를 위한것이다. (0이면 1로 바꾸려고...)
    return True
  return False

result = 0
for i in range(n):
  for j in range(m):
    if dfs(i, j) == True:
      result += 1

print(result)