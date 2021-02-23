N, K = map(int, input().split())

arr = [i for i in range(1, N + 1)]
resultArr = []

popNum = 0
while len(arr) > 0:
  popNum = (popNum + (K - 1)) % len(arr)
  popElement = arr.pop(popNum)
  resultArr.append(popElement)

print('<', end='')
for i in range(0, len(resultArr)):
    if i == len(resultArr) - 1:
        print(resultArr[i], end='')
    else:
        print(resultArr[i], end=', ')
print('>')
