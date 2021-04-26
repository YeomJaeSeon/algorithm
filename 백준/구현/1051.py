N, M = map(int, input().split())

arr = []
for i in range(N):
  innerArr = []
  num = input()
  for i in range(len(num)):
    innerArr.append(num[i])
  arr.append(innerArr)

def check(startPoint, length):
  [x, y] = startPoint
  # print("좌표:", x, y)
  if arr[x][y] == arr[x + length - 1][y] and arr[x + length - 1][y] == arr[x + length - 1][y + length - 1] and arr[x + length - 1][y + length - 1] == arr[x][y + length -1]:
    return True
  return False

minnValue = min(N, M) # 3
maxValue = max(N, M) # 5

checkLength = minnValue;
answer = 0

flag = True
flag2 = True
while(checkLength > 1):
  for i in range(0, maxValue - checkLength + 1):
    for j in range(0, minnValue - checkLength + 1):
      if minnValue == N:
        if check([j, i], checkLength) == True:
          answer = checkLength * checkLength
          flag = False
          break
      elif minnValue == M:
          if check([i, j], checkLength) == True:
            answer = checkLength * checkLength
            flag = False
            break
    if flag == False:
      flag2 = False
      break
  if flag2 == False:
    break
  checkLength -= 1

if answer == 0:
  print(1)
else:
  print(answer)


