n, k = map(int, input().split())

arr = [i for i in range(2, n + 1) ]

result = 0;
answer = ''

while len(arr) > 0:
    pm = arr[0] # 이게 소수임.
    i = 1
    while pm * i < n + 1:
        if pm * i in arr:
            result += 1
            arr.remove(pm * i)
            if result == k:
                answer = pm * i
                break            
        i += 1

print(answer)
