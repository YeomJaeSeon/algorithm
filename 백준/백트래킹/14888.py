import copy

N = int(input())
numbers = list(map(int, input().split()))

nums = [] # **
for i in range(len(numbers)):
  nums.append(numbers[i])
  if i == len(numbers) - 1:
    break
  nums.append(-1)

inputOps = list(map(int, input().split()))
operators = [] # **

cnt = 0
for i in range(len(inputOps)):
  if inputOps[i] != 0:
    for j in range(inputOps[i]):
      operators.append(i * 10 + cnt)
  cnt += 1
print(operators)
# operators
# 0 : +
# 1 : -
# 2 : *
# 3 : //
# print(operators) 

# print(nums)

max = 0
tmp = []
cases = []

def calculate(tmp):
  print("start")
  newNums = copy.deepcopy(nums)
  for i in range(len(tmp)):
    newNums[i * 2 + 1] = tmp[i]
  sum = int(newNums[0])
  for i in range(1, len(newNums) - 1):
    if i % 2 == 1:
      if newNums[i] // 10 == 0: # +
        sum = sum + int(newNums[i + 1])
      elif newNums[i] // 10 == 1: # -
        sum = sum - int(newNums[i + 1])
      elif newNums[i] // 10 == 2: # *
        sum = sum * int(newNums[i + 1])
      elif newNums[i] // 10 == 3: # //
        sum = sum // int(newNums[i + 1])
  return sum


def serach(operators, tmp):
  if len(tmp) == N - 1:
    cases.append(calculate(tmp))
    return
  for i in operators:
    if i in tmp:
      continue
    tmp.append(i)
    serach(operators, tmp)
    tmp.pop()

serach(operators, tmp)

for i in cases:
  print(i)