def bs(array, target, start, end):
  while start <= end:
    mid = (start + end) // 2
    if array[mid] == target:
      return mid
    elif array[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
    
  return None

n, target = list(map(int, input().split()))

array = list(map(int,input().split()))


result = bs(array, target, 0, n - 1)

if result == None:
  print("해당 원소가 없네요.")
else:
  print(result + 1)

# bs 반복문으로 풀었땅.