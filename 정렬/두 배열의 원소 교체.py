N, K = map(int, input().split())

a = list(map(int, input().split()))
b = list(map(int, input().split()))

ra = sorted(a)
rb = sorted(b, key=lambda x : -x)

for i in range(K):
  ra[i] = rb[i]

print(sum(ra))

# 파이썬 정렬라이브러리 사용, reverse=True사용해도되겠지만
# 난 key, 람다표현식 사용함