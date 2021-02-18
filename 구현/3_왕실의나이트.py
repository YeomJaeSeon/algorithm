pos = input()

col = ord(pos[0]) - 96
row = int(pos[1])
print(col, row)
cnt = 0

if col + 2 <= 8:
  if row + 1 <= 8:
    cnt += 1
  elif row - 1 >= 1:
    cnt += 1

if col - 2 >= 1:
  if row + 1 <= 8:
    cnt += 1
  elif row - 1 >= 1:
    cnt += 1

if row + 2 <= 8:
  if col + 1 <= 8:
    cnt += 1
  elif col - 1 >= 1:
    cnt += 1

if row - 2 >= 1:
  if col + 1 <= 8:
    cnt += 1
  elif col - 1 >= 1:
    cnt += 1

print(cnt)

# 탐색할 경우도 최대 8개이고 복잡하지도않으므로
# 그냥 시물레이션으로 풀수있음.