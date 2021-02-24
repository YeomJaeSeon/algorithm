# 이진트리 - 부모 노드1개, 자식노드 2개
# 전위순회 : root -> left -> right
# 중위순회 : left -> root -> right
# 후위순회 : left -> right -> root
# root를 언제 순회할지가 기준이다.
# 1991번

# 재귀함수로 풀어야할듯 딱 느낌이옴
# 입력되는 데이터도 많지않아서 구현에만 신경쓰면 될거같다

import sys
sys.setrecursionlimit(3000)

N = int(input())

tree = []
for _ in range(N):
  tree.append(list(input().split()))

visited = []
frontTree = []

for t in tree:
  frontTree.append(t[0])

def search(nodes):
  if nodes[0] != '.':
    visited.append(nodes[0])

  if nodes[1] != '.':
    leftIndex = frontTree.index(nodes[1])
    search(tree[leftIndex])
  if nodes[2] != '.':
    rightIndex = frontTree.index(nodes[2])
    search(tree[rightIndex])

search(tree[0])
for node in visited:
  print(node, end='')
print('')

visited=[]

def search2(nodes):
  if nodes[1] != '.':
    leftIndex = frontTree.index(nodes[1])
    search2(tree[leftIndex])
  if nodes[0] != '.':
    visited.append(nodes[0])
  if nodes[2] != '.':
    rightIndex = frontTree.index(nodes[2])
    search2(tree[rightIndex])

search2(tree[0])
for node in visited:
  print(node, end='')
print('')

visited = []

def search3(nodes):
  if nodes[1] != '.':
    leftIndex = frontTree.index(nodes[1])
    search3(tree[leftIndex])
  if nodes[2] != '.':
    rightIndex = frontTree.index(nodes[2])
    search3(tree[rightIndex])
  if nodes[0] != '.':
    visited.append(nodes[0])

search3(tree[0])
for node in visited:
  print(node, end='')
print('')