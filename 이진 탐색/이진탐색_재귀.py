
def bs(array, target, start, end):
  if start > end:
    return None
  mid = (start + end) // 2
  if array[mid] == target:
    return mid
  elif array[mid] > target:
    return bs(array, target, start, mid - 1)
  else:
    return bs(array, target, mid + 1, end)

n, target = list(map(int, input().split()))

array = list(map(int,input().split()))


result = bs(array, target, 0, n - 1)

if result == None:
  print("해당 원소가 없네요.")
else:
  print(result + 1)

# bs는 정렬이되어있어야함.
# bs는 반씩 줄여가면서 탐색하는 알고리즘임
# O(longn)시간복잡도
# 변수 세개씀. start middle end