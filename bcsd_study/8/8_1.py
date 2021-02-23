# 이진트리 - 부모 노드1개, 자식노드 2개
# 전위순회 : root -> left -> right
# 중위순회 : left -> root -> right
# 후위순회 : left -> right -> root
# root를 언제 순회할지가 기준이다.
# 1991번

# 재귀함수로 풀어야할듯 딱 느낌이옴

N = int(input())

tree = []
for _ in range(N):
  tree.append(list(input().split()))

visited = []
def front(tree):
  first = start[0] 
  second = frstart[1]
  third = start[2]

  visited.append(first)

