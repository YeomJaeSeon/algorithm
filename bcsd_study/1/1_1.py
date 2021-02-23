n, k = map(int, input().split())

arr = [i for i in range(2, n + 1) ]

result = 0;
answer = ''

while len(arr) > 0:
    pm = arr[0] # 이게 소수임.
    # arr[0]의 배수들을 저장할 새 배열 newArr
    # round(n / pm) + 1은 배수의 개수이다. 예를들면 1부터 10까지의 2의배수의 개수는 10 / 2 로 5개
    newArr = [pm * i for i in range(1, round(n / pm) + 1)]
    for i in range(len(newArr)):
        print(arr)
        if newArr[i] in arr:
            print('삭제되는 값: ', newArr[i])
            result += 1
            arr.remove(newArr[i])
            if result == k:
                answer = newArr[i]
                break

print(answer)

# 나는 배열 총 두개를 이용해서 풀었따.
# 메인 배열 arr하나
# 그리고 삭제된 소수의 배수 배열 newArr
# 메인배열에서 newArr하나씩 삭제하여서 풀었다.