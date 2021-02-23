from collections import deque

N, K = map(int, input().split())

nameLen = []
for _ in range(21):
    nameLen.append(deque([]))
# 이름의 길이를 가지고있는 배열
# 각 원소는 큐로이루어져있고 이큐에 등수가 들어갈 것이다.

cnt = 0
for ranking in range(N):
    personNameLength = len(input())
    while True:
        if len(nameLen[personNameLength]) == 0:
            nameLen[personNameLength].append(ranking)
            break;
        if ranking - nameLen[personNameLength][0] <= K:
            cnt += len(nameLen[personNameLength])
            nameLen[personNameLength].append(ranking)
            break;
        if ranking - nameLen[personNameLength][0] > K:
            nameLen[personNameLength].popleft()
            continue;
print(cnt)
