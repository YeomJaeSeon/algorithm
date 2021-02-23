import sys

N = int(sys.stdin.readline().rstrip())
arr = []
for i in range(0, N):
  a, b = map(int, sys.stdin.readline().rstrip().split())
  innerArr = [a, b]
  arr.append(innerArr)

arr.sort()

for i in range(0, len(arr)):
  print(arr[i][0], arr[i][1])


# 4주차 첫번째 문제는
# sort()나 sorted로 sorting하는 법을 일단배움
# 선택정렬 -> 병합정렬로 뻘짓함..
# 특히 입력받는데있어 아주 많은값이 입력에들어오면
# import sys
# sys.stdin.readline().rstrip()을통해 입력받기가능