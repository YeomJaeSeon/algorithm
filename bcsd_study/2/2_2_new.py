N, L = map(int, input().split())

flag = False
for i in range(L, 101):
    for x in range(round(N / i) - i, round(N / 2)):
        if (i * (2 * x + i - 1)) / 2 == N and x > 0:
            for num in range(0, i):
                print(x + num, end=' ')
            flag = True
            break;
        if flag == True:
            break;
    if flag == True:
        break;
if flag == False:
    print(-1)