N, M = map(int, input().split())

arr = list(map(int, input().split()))

start = 0
end = max(arr)

result = 0
while start <= end:
  sum = 0
  mid = (start + end) // 2 # 톱길이
  for tree in arr:
    if mid < tree:
      sum +=(tree - mid)
  if sum >= M:
    result = mid
    start = mid + 1
  else:
    end = mid - 1

print(result)