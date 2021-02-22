# 퀵정렬
arr = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quicksort(array, start, end):
  if start >= end:
    return
  pivot = start # 피벗은 첫번째 원소
  left = start + 1
  right = end

  while left <= end and array[pivot] >= array[left]:
    left += 1
  while right  > start and array[pivot] <= array[right]:
    right -= 1
  if left > right:
    array[right], array[pivot] = array[pivot], array[right]
  else:
    array[left], array[right] = array[right], array[left]
  
  quicksort(array, start, right - 1)
  quicksort(array, right + 1, end)



quicksort(arr, 0, len(arr) - 1)
print(arr)