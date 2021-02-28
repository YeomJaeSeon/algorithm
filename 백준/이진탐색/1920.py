import sys

N = int(input())
arr = list(map(int, sys.stdin.readline().rstrip().split()))
sortedArr = sorted(arr)

M = int(input())
search = list(map(int, sys.stdin.readline().rstrip().split()))


def bs(target):
  start = 0
  end = len(sortedArr) - 1
  while start <= end:
    mid = (start + end) // 2
    if sortedArr[mid] == target:
      return True
    elif sortedArr[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  return False


for num in search:
  if bs(num) == True:
    print(1)
  else:
    print(0)