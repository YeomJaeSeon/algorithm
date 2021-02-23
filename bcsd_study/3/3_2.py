N = int(input())
arr = list(map(int, input().split()))

count = 0
currentRemoveNum = 1
nextRemoveNum = arr[0]
while True:
  arr[currentRemoveNum - 1] = False
  count += 1
  print(currentRemoveNum, end=' ')
  if count == len(arr):
    break
  if nextRemoveNum < 0:
    nextRemoveNum = abs(nextRemoveNum)
    while nextRemoveNum != 0:
      if currentRemoveNum - 1 == 0:
        currentRemoveNum = len(arr)
      else:
        currentRemoveNum -= 1
      if arr[currentRemoveNum - 1] != False:
        nextRemoveNum -= 1

  else:
    while nextRemoveNum != 0:
      if currentRemoveNum - 1 == len(arr) - 1:
        currentRemoveNum = 1
      else:
        currentRemoveNum += 1
      if arr[currentRemoveNum - 1] != False:
        nextRemoveNum -= 1

  nextRemoveNum = arr[currentRemoveNum - 1]
