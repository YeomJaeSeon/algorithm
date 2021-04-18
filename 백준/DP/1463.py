x = int(input())

d = [0] * (1000001)

for i in range(2, 1000001):
  d[i] = d[i - 1] + 1 # 1을 뺄경우
  if i % 2 == 0:
    d[i] = min(d[i], d[i // 2] + 1)
  if i % 3 == 0:
    d[i] = min(d[i], d[i // 3] + 1)

print(d[x])

# DP 동적계획법 - 메모이제이션을 이용한 반복문.
# 점화식 세우는게 중요함. !!