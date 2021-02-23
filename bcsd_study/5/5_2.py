import sys
from itertools import combinations

N, S = map(int, sys.stdin.readline().rstrip().split())
arr = list(map(int, sys.stdin.readline().rstrip().split()))

count = 0

for i in range(1, N + 1):
  for j in combinations(arr, i):
    if sum(j) == S:
      count += 1
print(count)