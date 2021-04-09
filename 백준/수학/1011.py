T = int(input())


for i in range(T):
  a, b = map(int, input().split())
  if b - a == 1:
    print(1)
  else:
    k = 1
    cnt = 0
    while a + k < b - 1:
      if a + k == b - 1:
        break;
      cnt += 1
      a = a + k
      k += 1
      

    print(cnt + 2)