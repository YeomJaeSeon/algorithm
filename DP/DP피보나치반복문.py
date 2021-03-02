d = [0] * 100

d[1] = 1
d[2] = 1
n = 99

for i in range(3, n + 1):
  d[i] = d[i - 1] + d[i - 2]

print(d[n])

# 바텀업으로 DP를 품.
# 반복문을 이용해서 작은문제부터 차근차근 메모이제이션을 이용해서 하나씩 메모해가며 품
# 탑다운(재귀이용)보다 훨씬더 직관적이다. 난 탑다운 보다 바텀업으로 DP
# 문제 해결해야지.(반복문으로 작은문제부터 하나씩 해결)