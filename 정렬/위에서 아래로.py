N = int(input())

arr = []
for _ in range(N):
  arr.append(int(input()))

result = sorted(arr, reverse=True)

for i in range(len(result)):
  print(result[i], end=' ')