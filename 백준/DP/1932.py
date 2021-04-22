N = int(input())

arr = []
d = []

for i in range(N):
  arr.append(list(map(int, input().split())))
  d.append([0] * (i + 1))

d[0][0] = arr[0][0]
d[1][0] = d[0][0] + arr[1][0]
d[1][1] = d[0][0] + arr[1][1]

for i in range(1, N):
  for j in range(i + 1):
    if j == 0: #좌변
      d[i][j] = d[i - 1][j] + arr[i][j]
    elif i == j: #우변
      d[i][j] = d[i - 1][j - 1] + arr[i][j]
    else:
      d[i][j] = max(d[i - 1][j - 1] + arr[i][j], d[i - 1][j] + arr[i][j])

print(max(d[N - 1]))

# 좌변 우변은 항상 더해지는 값이고 그외의 쉘의 값들은 왼쪽위에서올지 오른쪽위에서올지 더큰녀석이 오면됨
# 너무간단한 DP문제라 메모이제이션 바텀업으로품
# 점화식도 너무간단함