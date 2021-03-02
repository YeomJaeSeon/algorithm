# DP문제, 점화식 : an = max(an-1, an-2 + K)
n = int(input())

arr = list(map(int, input().split()))

dp = [0] * 101

dp[0] = arr[0]
dp[1] = max(arr[0], arr[1])

for i in range(2, n):
  dp[i] = max(dp[i - 1], dp[i - 2] + arr[i])

print(dp[n - 1])