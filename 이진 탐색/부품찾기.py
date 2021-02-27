import sys
N = int(input())
exist = list(map(int, sys.stdin.readline().rstrip().split()))
M = int(sys.stdin.readline().rstrip())
order = list(map(int, sys.stdin.readline().rstrip().split()))

sortExist = sorted(exist)
print(sortExist)

def bs(arr, target, start, end):
  if start > end:
    return False
  mid = (start + end) // 2
  if arr[mid] == target:
    return True
  elif arr[mid] > target:
    return bs(arr, target, start, mid - 1)
  else:
    return bs(arr, target, mid + 1, end)

for i in order:
  if bs(sortExist, i, 0, N - 1) == True:
    print('yes', end=' ')
  else:
    print('no', end=' ')