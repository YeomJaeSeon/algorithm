# 결과 수열이 1씩 작으면 바로 pop이루어진것
# 결과 수열이 갑자기 커지면 push가 이루어지고 그뒤에 
# pop이이루어진것

import sys
n = int(sys.stdin.readline().rstrip())

resultArr = []

for i in range(n):
  resultArr.append(int(sys.stdin.readline().rstrip()))

# print(resultArr)

stackArr = []

printArr = []

j = 1 # stack에 입력되는 수
for i in range(len(resultArr)):
  while j <= resultArr[i]:
    stackArr.append(j)
    printArr.append('+')
    # print("+")
    j += 1
    # print(stackArr)
  if resultArr[i] == stackArr[len(stackArr) - 1]:
    stackArr.pop()
    printArr.append('-')
    # print("-")
    # print(stackArr)
  else:
    printArr = ['NO']
    break;

for i in range(len(printArr)):
  print(printArr[i])

