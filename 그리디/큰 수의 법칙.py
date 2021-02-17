# 배열이 주어지면 배열내 원소를 M번더해서 큰수를 만들어라, 단, 한 인덱스의 원소를 연속해서 더하는건 K번을 초과할순 없다.

# 1방법

# N, M, K = map(int, input().split())
# arr = list(map(int, input().split()))

# newArr = sorted(arr)

# sum = 0
# value = newArr[-1]

# for i in range(1, M + 1):

#   if i % (K + 1) == 0:
#     value = newArr[-2]
#   else:
#     value = newArr[-1]
#   sum += value
# print(sum)

# 2 방법 

N, M, K = map(int, input().split())
arr = list(map(int, input().split()))

newArr = sorted(arr)

first = newArr[-1]
second = newArr[-2]

count = (M // (K + 1)) * K
count += M % (K + 1)
#count 는 가장 큰수가 저장된 횟수

sum = 0
sum += count * first
sum += (M - count) * second

print(sum)

## 위 문제는 그리디 알고리즘으로 현재 상황에 가장 좋은 것만 고르면 결국 결과도 좋을거라는 확신이 있어야 풀수있는 문제이다.
# 지금 당장 가장 큰수를 K번더하고 두번째 큰수 한번더하고를 반복하면 문제에서 요구하는'큰 수'를 구할수 있으므로 그리디 알고리즘으로 푼다.

#그리디 알고리즘은 문제를 보고 '그리디 알고리즘으로 풀면 되는구나'를 깨달을수 있어야함