n = int(input())

currentTime = 0
cnt = 0
for h in range(0, n + 1):
  for m in range(60):
    for s in range(60):
      currentTime = 10000 * h + 100 * m + s
      if '3' in str(currentTime):
        cnt += 1

print(cnt)

# int to string : str()메소드로
# 완전탐색해도 경우의수가 86400으로 10만도 되지않으므로
# 어렵지않다.

# 완전탐색 문제는 비효율적이므로 데이터가 100만개 이하일 때
# 만 사용하도록 하자..