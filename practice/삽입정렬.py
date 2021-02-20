arr = [6, 3, 4, 1, 2, 9, 7, 8, 5, 0]

for i in range(1, len(arr)):
  for j in range(i, 0, -1):
    if arr[j] < arr[j - 1]:
      arr[j - 1], arr[j] = arr[j], arr[j - 1]
    else:
      break
print(arr)

# else문보면 삽입할 데이터보다 왼쪽에잇는 뎅터들은 이미
# 정렬이되어있는상태임
# 그래서 삽입할 데이터보다 더 작은 데이터를 만나면 바로 break
# 그러므로 거의 정렬되어있는 데이터 set에대해선 삽입정렬은 엄청빠르다

# 추가로 range3번째 매개변수 -1일땐
# for i in range(start, end, -1) - start부터 end + 1까지 1씩뺌