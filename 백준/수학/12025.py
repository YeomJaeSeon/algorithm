# 1 -> 6, 6 -> 1, 2 -> 7, 7 -> 2
# solve : 모두1, 모두2로바꾼거 ~ 모두6모두7로바꾼경우의수의 사전순 k번째가 비밀번호

N = input() # string으로받음
k = int(input())

first = ""
second = ""

for i in range(0, len(N)):
  if N[i] == '6':
    first += '1'
  elif N[i] == '7':
    first += '2'
  else:
    first += N[i]
  
  if N[i] == '1':
    second += '6'
  elif N[i] == '2':
    second += '7'
  else:
    second += N[i]

first = (int)first;
second = (int)second;
print(first)
print(second)