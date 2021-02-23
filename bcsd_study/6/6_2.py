import sys

n = int(input())
arr = list(map(int, input().split()))

result = []
stackArr = []


for i in range(len(arr)):
  while stackArr:
    if arr[i] < stackArr[-1][1]:
      result.append(stackArr[-1][0] + 1)
      break;
    stackArr.pop()

  if not stackArr:
    result.append(0)
      
  stackArr.append([i, arr[i]])



for i in range(len(result)):
  print(result[i], end=' ')