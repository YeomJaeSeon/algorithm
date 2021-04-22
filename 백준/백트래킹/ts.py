import copy

def calculate(test):
  tmp = []
  for i in test:
    if len(tmp) == 3:
      print(tmp)
      if tmp[1] == '<':
        if not tmp[0] < tmp[2]:
          return False
      if tmp[1] == '>':
        if not tmp[0] > tmp[2]:
          return False
      tmp = [tmp[2]]
      print(tmp)
    tmp.append(i)
    print(tmp)
  if len(tmp) == 3:
    print(tmp)
    if tmp[1] == '<':
      if not tmp[0] < tmp[2]:
        return False
    if tmp[1] == '>':
      if not tmp[0] > tmp[2]:
        return False
    tmp = [tmp[2]]
  
  return True

print(calculate("1>2>3"))

# for i in range(2, len(arr)):
#   arr[i-2]
#   arr[i-1]
#   arr[i]

#   if i.isdigit():
#     if i == '<':

#     else:
