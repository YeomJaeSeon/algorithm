T = int(input())

for _ in range(T):
  n = int(input())

  d = [[-1, -1]  for _ in range(41)] # 리스트 컴프레헨션으로 2차원배열 초기화 
  # d[i][j] i 는 n, j는 0, 1의 count의 idx
  d[0][0] = 1
  d[0][1] = 0

  d[1][0] = 0
  d[1][1] = 1

  for i in range(2, 41):
    d[i][0] = d[i-1][0] + d[i-2][0]
    d[i][1] = d[i-1][1] + d[i-2][1]
  
  print(d[n][0], d[n][1])
  
  # fibonacci(n)
  # print(count0, count1)


