import math
n = int(input())

cnt = 0

while True:
  if n < 10:
    break;
  if n % 10 >= 5:
    n *= 0.1
    n = math.ceil(n)
    n *= 10
  else:
    n *= 0.1
    n = math.floor(n)
    n *= 10
  cnt += 1
  n //= 10
n *= math.pow(10, cnt)

print(int(n))