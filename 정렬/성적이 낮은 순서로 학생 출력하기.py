n = int(input())

arr= []
for _ in range(n):
  arr.append(list(input().split()))

result = sorted(arr, key=lambda x:int(x[1]))

print(result)
for i in range(len(result)):
  print(result[i][0], end=' ')

# 이문제는 파이썬 정렬라이브러리 + key와 lambda로 custom sorting하면 되는 문제임
# 주어지는 데이터가 적으니 계수정렬사용해도됨.