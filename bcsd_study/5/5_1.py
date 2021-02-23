import sys

n = int(sys.stdin.readline().rstrip())

arr = [1, 2, 4]
for i in range(4, 11):
  count = 0
  for i in range(i - 4, i - 1):
    count += arr[i]
  arr.append(count)

for i in range(n):
  a = int(sys.stdin.readline().rstrip())
  print(arr[a - 1])