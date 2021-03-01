# 파라메트릭 서치(최적화문제 -> 결정문제)
import sys

K, N = map(int, input().split())

arr = []

for _ in range(K):
  arr.append(int(sys.stdin.readline().rstrip()))

ans = []
def bs():
  start = 1 # 0부터시작해서 ZeroDIvisonError가 자꾸떴음
  end = max(arr)
  while start <= end:
    sum = 0
    mid = (start + end) // 2
    for lensun in arr:
      sum += (lensun // mid)
    if sum >= N:
      start = mid + 1
    else:
      end = mid - 1
  
  return end

print(bs())
    