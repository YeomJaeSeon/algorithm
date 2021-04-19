N = int(input())

arr = []

for _ in range(N):
  arr.append(list(map(int, input().split())))

d = [[0, 0, 0] for _ in range(1001)]

d[1] = arr[0]

for i in range(2, N + 1):
  d[i][0] = min(d[i - 1][1] + arr[i - 1][0], d[i - 1][2] + arr[i - 1][0])
  d[i][1] = min(d[i - 1][0] + arr[i - 1][1], d[i - 1][2] + arr[i - 1][1])
  d[i][2] = min(d[i - 1][0] + arr[i - 1][2], d[i - 1][1] + arr[i - 1][2])

print(min(d[N]))

# DP인데 생각하기가좀어려웠음 일단 점화식 생각하는게어려웠다. 실수 두번에 총 네번틀림
# 하나의 값만 메모이제이션하는게아니라 모든 경우의 최적의 해를 메모이제이션하면 너무너무 쉽게푸는 문제임
# 이웃간의 색깔이 달라야하므로 경우는 다~ 다르다. 그런데 총 세개의 경우에 모두 최적의해를 메모하면 된다..