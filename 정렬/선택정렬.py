arr = [6, 3, 4, 1, 2, 9, 7, 8, 5, 0]

for i in range(len(arr)):
  min = i
  for j in range(i + 1, len(arr)):
    if arr[j] < arr[min]:
      min = j
  arr[i], arr[min] = arr[min], arr[i]
  # 여분(temp)의 변수이용안하고 swap을 통해 파이썬에선 교체가능
  
print(arr)