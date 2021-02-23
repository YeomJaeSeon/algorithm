# 길이 짧은게 먼저
# 길이가 같으면 각자리수의 합을더해서 작은게 앞에
# - 숫자인것만더해.
# 2번으로도 안되면 사전순

# 파이썬은 문자열이 배열로 나타내어짐

import sys

n = int(sys.stdin.readline().rstrip())

arr = []

for i in range(0, n):
  arr.append(sys.stdin.readline().rstrip())

def isDigit(str):
  try:
    int(str)
    return True
  except ValueError:
    return False

def addInt(serialNum):
  sum = 0
  for i in range(0, len(serialNum)):
    if isDigit(serialNum[i]):
      sum += int(serialNum[i])
  return sum;

arr = sorted(arr, key=lambda x : (len(x), addInt(x), x))

  
for i in range(0, len(arr)):
  print(arr[i])



# 4주차 2번쨰문제는 파이썬에서 사용하는
# sorted함수를 통해서 sorting하는데
# key를 통해서 custom 정렬하는 방법을배움
# 특히 다중조건에대해 정렬하는법 (key의 사용을 배움)
# lambda도배움