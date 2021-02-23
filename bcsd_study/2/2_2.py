# N <= 1,000,000,000
# 2 <= L <= 100
# N은 연속된 양수들의 합
# 연속된 양수들의 개수는 L보다 크거나 같되
# 가장 짧은 리스트를 '구하자'

N, L = map(int, input().split())
while True:
    crucialNum = N // L
    # print("결정값: ", crucialNum)
    arr = [crucialNum] * L
    # print("초기 arr: ", arr)
    # 나누어떨어진다는 뜻
    if crucialNum * L == N:
        if L % 2 == 0:
# L이 짝수
            # L // 2 - 1개 (좌변 배열)
            for i in range(0, L // 2 - 1):
                arr[i] -= L // 2 + i
            # 중앙
            arr[L // 2 - 1] = crucialNum
            # 우변배열
            for i in range(L // 2, L):
                arr[i] = arr[i - 1] + 1
        else:
# L이 홀수
            # 이경우는 무조건 ok임
            for i in range(0, L // 2):
                arr[i] -= (L // 2)
                arr[i] += i
            arr[L // 2] = crucialNum
            for i in range(L // 2, L):
                arr[i] = arr[i - 1] + 1
    # 나누어떨어지지않아.
    else:
        if L % 2 == 0:
# L이 짝수
            # 이경우는 무조건 ok임 - 무조건은아님 반례 - 201 4
            # L // 2 - 1개 (좌변 배열)
            for i in range(0, L // 2 - 1):
                arr[i] -= L // 2 - 1
                arr[i] += i
            # print("좌변: ", arr)
            # 중앙
            arr[L // 2 - 1] = crucialNum
            # print("중앙값: ", arr)
            # 우변배열
            for i in range(L // 2, L):
                arr[i] = arr[i - 1] + 1
            # print("우변: ", arr)
        else:
# L이 홀수
            for i in range(0, L // 2):
                arr[i] -= (L // 2)
                arr[i] += i
            arr[L // 2] = crucialNum
            for i in range(L // 2, L):
                arr[i] = arr[i - 1] + 1
    if arr[0] >= 0:
        if sum(arr) == N:
            for i in arr:
                print(i, end=' ')
            break;
    L += 1
    if L > 100:
        print(-1)
        break
