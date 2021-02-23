n = int(input())

result = 1
while n > 0:
    result *= n
    n -= 1

count = 0
while result != 0:
    if result % 10 == 0:
        count += 1
        result //= 10
    else: break


print(count)

# /의 결과는 무조건 float
# float overflow발생 (500!같은 경우 너무큼)
# python3에서는 integer가 overflow가 없음 그래서 //를 통해서 정수를 구함 (/를 통해서 float을 구하는것대신)
# 참고로 //는 정수를 리턴함.
# //를 통해서 overflow문제해결