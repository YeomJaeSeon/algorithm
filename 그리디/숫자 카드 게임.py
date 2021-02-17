# N, M = map(int, input().split())

# arr = []
# for i in range(N):
#   henglist = list(map(int, input().split()))
#   arr.append(henglist)
  
# minArr = []
# for num in arr:
#   minArr.append(min(num))

# print(max(minArr))

# 각 행의 제일 작은값중 제일 큰값을 고르면 답이나옴.
# 현재상황에서 제일 작은값만 고르고 마지막에 max만 고르면 되는문제임

# 좀더 나은 풀이 불필요한 코드들이 위에는 많다
N, M = map(int, input().split())


result = 0
for i in range(N):
  arr = list(map(int, input().split()))
  result = max(result, min(arr))

print(result)