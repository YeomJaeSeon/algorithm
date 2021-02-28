import sys
sys.setrecursionlimit(10000)

class Node:
  def __init__(self, item):
    self.val = item
    self.left = None
    self.right = None

class BinaryTree: # 이진트리
  def __init__(self):
    self.head = Node(None)
  
  def insert(self, item):
    if self.head.val is None:
      self.head.val = item
    else:
      self.addnode(self.head, item)

  def addnode(self, cur, item):
    if cur.val > item:
      if cur.left != None:
        self.addnode(cur.left, item)
      else:
        cur.left = Node(item)
    elif cur.val < item:
      if cur.right != None:
        self.addnode(cur.right, item)
      else:
        cur.right = Node(item)
    
  def postorder(self, cur):
    if cur.left != None:
      self.postorder(cur.left)
    if cur.right != None:
      self.postorder(cur.right)
    print(cur.val)

btree = BinaryTree()

while True:
  try:
    num = int(input())
    btree.insert(num)
  except EOFError:
    break

btree.postorder(btree.head)

# 전위순회한 결과를 이진트리에 하나씩 삽입 -> BST됨.  다시 후위순회.