# 5639 이진 검색 트리
# BST - 이진탐색
# 전위는 루트 좌 우 : 중간 작은거 큰거
# 후위는 좌 우 루트 : 작은거 큰거 중간
import sys
sys.setrecursionlimit(10**9)

arr = []
while True:
  try:
    arr.append(int(input()))
  except EOFError:
    break
  
recursion = 1
result = []
def graph(arr):
  global recursion
  recursion+=1
  if len(arr) == 3:
    result.append(arr[1])
    result.append(arr[2])
    result.append(arr[0])
    return
  elif len(arr) == 2:
    if arr[0] > arr[1]:
      result.append(arr[1])
      result.append(arr[0])
    else:
      result.append(arr[0])
      result.append(arr[1])
    return
  elif len(arr) == 1:
    result.append(arr[0])
    return
  else:
    smallArr = [i for i in arr if i < arr[0]]
    graph(smallArr)
    bigArr = [i for i in arr if i > arr[0]]
    graph(bigArr)
    result.append(arr[0])
    return

graph(arr)
# print('호출수', recursion)
for i in result:
  print(i)
