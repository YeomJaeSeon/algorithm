# 큐
from collections import deque

queue = deque()

queue.append(1)
queue.append(2)
queue.append(0)

queue.popleft()
print(queue)