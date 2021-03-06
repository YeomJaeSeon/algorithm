# 탐색
- 많은 데이터중 원하는 데이터를 찾는 과정

## 스택
- LIFO
- 재귀함수와 내부적으로 동일함.

## 큐
- FIFO
- dequeue 라이브러리를 이용
```
from collections import dequeue

queue = dequeue()
(push : append)
(pop : popleft)
```

## 재귀함수
- 자기자신을 다시 호출하는 함수
- 스택자료구조와 내부적으로 동일함.
- 재귀함수는 코드는 간결하다.(대신 직관적이지가 않음..)

# 탐색알고리즘

## 그래프
- 노드(정점)와 간선으로 표현
- 두 노드가 간선으로 연결된 경우를 '두 노드는 인접하다'라고 표현함
- 그래프를 프로그래밍적으로 표현하는 두가지방법
1. 인접행렬 방식
- 2차원 배열로 그래프의 연결관계 표현

2. 인접 리스트 방식
- 리스트로 그래프의 연결 관계 표현 

두 방식의 차이 
- 인접행렬 방식은 불필요한 데이터도 저장되므로 메모리낭비가 있다.
- 대신 인접 리스트 방식은 어떠한 정보를 얻기위해서(어떤 노드에서 어떤노드의 거리) 불필요한 순회를 해야함
- 인접행렬방식은 정보를 얻는 속도가 빠르다.

## DFS
- Depth First Search
- 깊이 우선 탐색
- 그래프를 탐색하는데 깊이를 우선으로 탐색함
- 최대한 멀리있는 노드부터 탐색
- 스택 자료구조에 기초하므로 간단하게 구현 가능
- 스택을 이용하므로 재귀함수로 간단하게 구현 가능

## BFS
- Breadth First Search
- 너비 우선 탐색
- 그래프를 탐색하는데 가까운 녀석들을 먼저 탐색함(인접 노드들을 먼저 탐색)
- DFS는 최대한 멀리있는 노드부터 탐색하는 반면 BFS는 가까운 노드들부터 탐색
- **큐** 자료구조를 이용하는 것이 정석
- collections라이브러리의 `deque`를 이용하자

