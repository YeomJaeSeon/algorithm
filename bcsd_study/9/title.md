## 들어가기전에 복습

---

- DFS와 BFS는 그래프 탐색 알고리즘이다.
- 그래프란 간선과 노드로 이루어져있는 데이터 집합이다.
- 인접한 노드라는것은 하나의 노드와 노드사이에 하나의 간선만 존재한다는 것이다.
- DFS는 깊이 우선탐색으로 먼 노드부터 먼저 탐색 한다는 것이다. stack을 이용한다. stack과 재귀함수는 구조가 같기 때문에 재귀함수를 응용하면 더쉽게 DFS를 구현할수 있다.
- BFS는 너비 우선탐색으로 인접한 노드들부터 탐색하는 그래프 탐색 알고리즘이다. 인접한 노드들부터 탐색하기 때문에 queue자료구조를 이용한다. python에선 deque를 이용해서 queue를 구현한다. popleft와 append로 queue에 데이터를 빼고 넣을수 있다. BFS는 가중치가 없는 간선에서 최단거리, 등을 찾을 때 유용하다. 예를 들면 토마토 문제가 있다.