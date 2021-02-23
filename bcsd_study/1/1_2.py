while True:
    n = int(input())
    if not 1 <= n <= 123456:
        break;
    allNum2 = [False, False] + [True] * (2 * n - 1)

    pm = 2
    while True:
        for i in range(2, round(2 * n / pm) + 1):
            if pm * i > 2 * n:
                break;
            if allNum2[pm * i] == True:
                allNum2[pm * i] = False
        pm += 1
        if pm * 2 > 2 * n:
            break;
    count = 0
    for i in range(n + 1, 2 * n + 1):
        if allNum2[i] == True:
            count += 1
    print(count)