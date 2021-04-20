N = int(input())

a = []
for _ in range(N):
  a.append(int(input()))

d = [0] * 300

if N >= 1:
  d[0] = a[0]
if N >= 2:
  d[1] = max(a[0], a[0] + a[1])
if N >= 3:
  d[2] = max(a[0] + a[2], a[1] + a[2])

  for i in range(3, N):
    d[i] = max(d[i - 3] + a[i - 1] + a[i], d[i - 2] + a[i])

print(d[N - 1])