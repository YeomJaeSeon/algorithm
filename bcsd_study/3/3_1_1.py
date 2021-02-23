N, K = map(int, input().split())

arr = []
resultArr = []

for i in range(0, N):
    arr.append(True)

exitValue = 0
z = 0
i = 1 # K관한 변수
while True:
    if arr[z] == False:
        z += 1
    else:
        if i == K:
            arr[z] = False
            resultArr.append(z + 1)
            exitValue += 1
            if exitValue == N:
                break;
            i = 0
        z += 1
        i += 1
    if z == N:
        z = 0

print('<', end='')
for i in range(0, len(resultArr)):
    if i == len(resultArr) - 1:
        print(resultArr[i], end='')
    else:
        print(resultArr[i], end=', ')
print('>')