import sys

N, M = map(int, sys.stdin.readline().rstrip().split())
# 떡 개수, 손님이 요청한 총길이
arr = list(map(int, sys.stdin.readline().rstrip().split()))

def bs(array, start,end):
  result = 0
  while start <= end:
    total = 0
    mid = (start + end) // 2
    for x in arr:
      if x > mid:
        total += (x - mid)
    
    if total > M :
      start = mid + 1
    else:
      result = mid
      end = mid - 1
    
  
  return result

print(bs(arr, 0, max(arr)))