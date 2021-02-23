N = int(input())
arr = list(map(int, input().split()))

ballonNum = [i for i in range(1, N + 1)]
resultArr = []
idx = 0

K = arr.pop(idx)
resultArr.append(ballonNum.pop(idx))

while len(arr) > 0:
  if K > 0:
    idx = (idx + (K - 1)) % len(arr)
  else:
    K = K * -1
    idx = len(arr) - idx - 1
    idx = len(arr) - ((idx + (K)) % len(arr)) - 1
  K = arr.pop(idx)
  resultArr.append(ballonNum.pop(idx))

for i in range(0, len(resultArr)):
  print(resultArr[i], end=' ')

