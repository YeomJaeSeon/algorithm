def bs(arr, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if arr[mid] == target:
      return mid
    elif arr[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  
  return None

result = bs([1, 3, 5 ,7, 9, 11 ,13 ,15 ,17 ,19], 19, 0, 9)

if result == None:
  print('원소없음')
else:
  print(result + 1)