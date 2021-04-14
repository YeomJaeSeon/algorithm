n = int(input())

arr = list(map(int, input().split()))

d = [0] * 1000

d[0] = arr[0]

for i in range(1, n):
  if arr[i] > arr[i - 1]: # 증가할경우
    d[i] = d[i - 1] + arr[i] # 무조건더한게 최대
  else: #그렇지않으면
    d[i] = max(d[i - 1], arr[i]) # d[i- 1]최적해 와 arr[i]중 최대값이 그다음 최대값

print(d)
print(d[n - 1])
