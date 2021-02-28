# 5639 이진 검색 트리
# BST - 이진탐색
# 전위는 루트 좌 우 : 중간 작은거 큰거
# 후위는 좌 우 루트 : 작은거 큰거 중간
import sys
sys.setrecursionlimit(10**9)

array = []
while True:
  try:
    array.append(int(input()))
  except EOFError:
    break

result = []
def graph(arr):
  print(result)
  length= arr[1] - arr[0] + 1
  if length == 3:
    result.append(array[arr[1] - arr[0] - 1])
    result.append(array[arr[1]])
    result.append(array[arr[0]])
    return
  elif length == 2:
    if array[arr[0]] > array[arr[1]]:
      result.append(array[arr[1]])
      result.append(array[arr[0]])
    else:
      result.append(array[arr[0]])
      result.append(array[arr[1]])
    return
  elif length == 1:
    result.append(array[arr[0]])
    return
  isBig = False
  for i in range(arr[0], arr[1] + 1):
    if array[i] > array[0]:
      isBig = i # 큰녀석이 나온 처음 인덱스
      break
  if isBig != False: # 큰녀석이 나왔다.
    graph([arr[0], isBig - 1]) # 작은거 부터
    graph([isBig, arr[1]])  # 큰거
  else: # 큰녀석이 안나왔따.
    graph([arr[0], arr[1]])

    result.append(array[0]) # 트
    return

graph([0,len(array) - 1])

for i in result:
  print(i)
