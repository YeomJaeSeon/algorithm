arr = [6, 3, 4, 1, 2, 9, 7, 8, 5, 0]

for i in range(1, len(arr)):
  for j in range(i, 0, -1): # i부터 0 + 1까지 1씩감소
    if arr[j] < arr[j - 1]:
      arr[j], arr[j - 1] = arr[j - 1], arr[j]
    else:
      # 삽입할 데이터보다 작은녀석을 만나면 그즉시 멈춤
      # 이는 삽입정렬 특징으로 삽입할 데이터 왼쪽 데이터들은 이미 정렬이 되어있으므로 더작은 데이터 만나면
      # 그즉시 멈춘다.
      break;

print(arr)