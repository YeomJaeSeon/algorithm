import itertools
from itertools import product

a = [0, 0, 0, 1, 1, 1, 2, 2, 3, 3]
b = itertools.permutations(a)

for i in b:
  print(i, end=' ')

