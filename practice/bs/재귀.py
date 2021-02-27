# 재귀로 bs풀기

arr = [1, 3, 5 ,7, 9, 11 ,13 ,15 ,17 ,19]

def bs(arr, target, start, end):
  if start > end:
    return None
  mid = (start + end) // 2
  if arr[mid] == target:
    return mid
  elif arr[mid] > target:
    return bs(arr, target, start, mid - 1)
  else:
    return bs(arr, target, mid + 1, end)

result = bs(arr, 15, 0, 9)

if result == None:
  print("해당 원소가 없네요.")
else:
  print(result + 1)