import sys

n = int(sys.stdin.readline().rstrip())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

result = []
stackArr = []

for i in range(len(arr)):
  if i == 0:
    stackArr.append([i, arr[i]])
  else:
    for j in range(len(stackArr)-1, -1, -1):
      if arr[i] > stackArr[j][1]:
        stackArr.pop()
    stackArr.append([i, arr[i]])

  if len(stackArr) == 1:
    result.append(0)
  else:
    result.append(stackArr[-2][0] + 1)

for i in range(len(result)):
  print(result[i], end=' ')