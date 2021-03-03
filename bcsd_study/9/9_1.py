# 2606

N =int(input())
M = int(input())

visited = [0] * (N + 1)
visited[1] = 1

for _ in range(M):
  a, b= map(int, input().split())
  if visited[a] == 0:
    continue
  else:
    visited[b] = 1

cnt = 0
for isVisit in visited:
  if isVisit == 1:
    cnt += 1

print(cnt - 1)

# 틀림  그래프 탐색 알고리즘 사용 X