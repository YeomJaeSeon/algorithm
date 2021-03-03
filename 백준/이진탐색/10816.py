import sys

N = int(sys.stdin.readline().rstrip())
cards = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(sys.stdin.readline().rstrip())
nums = list(map(int, sys.stdin.readline().rstrip().split()))

cards.sort()

def upper_bound(start, end, target):
  while start < end:
    mid = (start + end) // 2
    if target >= cards[mid]:
      start = mid + 1
    else:
      end = mid
  
  return end + 1

def lowr_bound(start, end, target):
  while start < end:
    mid = (start + end) // 2
    if target > cards[mid]:
      start = mid + 1
    else:
      end = mid
    
  return end + 1
for num in nums:
  print(upper_bound(0, len(cards), num) - lowr_bound(0, len(cards), num), end=' ')