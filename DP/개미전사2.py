# 이문제도 큰문제를 작은문제로 나눌수있음.
# 작은문제들은 항상 같은 결과를 도출함.
# 메모이제이션 - DP테이블으 ㄹ이용한 바텀업으로풀자
# 먼저 점화식!
n = int(input())
arr = list(map(int, input().split()))

d = [0] * 100

d[0] = arr[0]
d[1] = max(arr[0], arr[1])

for i in range(2, n):
  d[i] = max(d[i - 1], d[i - 2] + arr[i])

print(d[n - 1])