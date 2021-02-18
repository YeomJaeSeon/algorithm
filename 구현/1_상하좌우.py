n = int(input())
arr = list(input().split())

pos = [1, 1]
for direction in arr:
  if direction == 'R':
    pos[1] += 1
    if pos[1] > n:
      pos[1] -= 1
  elif direction == 'L':
    pos[1] -= 1
    if pos[1] < 1:
      pos[1] += 1
  elif direction == 'U':
    pos[0] -= 1
    if pos[0] < 1:
      pos[0] += 1
  else:
    pos[0] += 1
    if pos[0] > n:
      pos[0] -= 1

print(pos[0], pos[1])

