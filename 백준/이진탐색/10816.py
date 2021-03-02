import sys

N = int(sys.stdin.readline().rstrip())
cards = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().rstrip().split()))

cards.sort()

def bs(target):
  start = 0
  end = len(cards) - 1
  sum = 0
  while start <= end:
    mid = (start + end) // 2
    if cards[mid] == target:
      

    elif cards[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  return sum 

for num in nums:
  print(bs(num), end=' ')