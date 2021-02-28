import sys

N = int(input())
cards = list(map(int, sys.stdin.readline().rstrip().split()))

M = int(input())
searchNums = list(map(int, sys.stdin.readline().rstrip().split()))

sortedCards = sorted(cards)

def bs(target):
  start = 0
  end = len(sortedCards) - 1
  while start <= end:
    mid = (start + end) // 2
    if sortedCards[mid] == target:
      return True
    elif sortedCards[mid] > target:
      end = mid - 1
    else:
      start = mid + 1
  return False

for serachNum in searchNums:
  if bs(serachNum) == True:
    print(1, end=' ')
  else:
    print(0, end=' ')