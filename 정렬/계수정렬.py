# 계수 정렬

arr = [7, 5, 9, 0, 3, 1, 6, 2, 9, 1, 4, 8, 0, 5, 2]

count = [0] * (max(arr) + 1)

for i in range(len(arr)):
  count[arr[i]] += 1

for i in range(len(count)):
  for _ in range(count[i]):
    print(i, end=' ')

# 어렵지않아서 이해하기도 쉬운데 수행시간도 효율적이니 기억하도록하자
