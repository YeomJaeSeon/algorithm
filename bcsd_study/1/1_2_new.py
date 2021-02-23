allNum = [False, False] + [True] * (250000)
pm = 2
while True:
    for i in range(2, round(len(allNum) / pm)):
        if pm * i > len(allNum):
            break;
        if allNum[pm * i] == True:
            allNum[pm * i] = False
    pm += 1
    if pm == len(allNum):
        break;

while True:
    n = int(input())
    if n == 0:
        break;
    count = 0
    for i in range(n + 1, 2 * n + 1):
        if allNum[i] == True:
            count += 1
    print(count)