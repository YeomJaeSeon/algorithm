N, M = map(int, input().split())
posx, posy, direction = map(int, input().split())

gameMap = []
for i in range(N):
  rowMap = list(map(int, input().split()))
  gameMap.append(rowMap)

gameMap[posx][posy] = -1
visitCnt = 1

spinCnt = [0, 0, 0, 0]

while True:
  for row in gameMap:
    print(row)
  if direction == 0:
    direction = 3
    if spinCnt[0] == 0:
      spinCnt[0] += 1
    else:
      if gameMap[posx][posy + 2] != 1:
        posy += 2
        spinCnt = [0, 0, 0, 0]
      else:
        break;
    # 방문한 육지
    if gameMap[posx][posy - 1] == 0:
      posy -= 1
      gameMap[posx][posy] = -1
      visitCnt += 1
      spinCnt = [0, 0, 0, 0]
  elif direction == 1:
    direction = 0
    if spinCnt[1] == 0:
      spinCnt[1] += 1
    else:
      if gameMap[posx + 2][posy] != 1:
        posx += 2
        spinCnt = [0, 0, 0, 0]
      else:
        break;
    # 방문한 육지
    if gameMap[posx - 1][posy] == 0:
      posx -=1
      gameMap[posx][posy] = -1
      visitCnt += 1
      spinCnt = [0, 0, 0, 0]
  elif direction == 2:
    direction = 1
    if spinCnt[2] == 0:
      spinCnt[2] += 1
    else:
      if gameMap[posx][posy - 2] != 1:
        posy -= 2
        spinCnt = [0, 0, 0, 0]
      else:
        break;
    # 방문한 육지
    if gameMap[posx][posy + 1] == 0:
      posy += 1
      gameMap[posx][posy] = -1
      visitCnt += 1
      spinCnt = [0, 0, 0, 0]
  else:
    direction = 2
    if spinCnt[3] == 0:
      spinCnt[3] += 1
    else:
      if gameMap[posx - 2][posy] != 1:
        posx -= 2
        spinCnt = [0, 0, 0, 0]
      else:
        break;
    # 방문한 육지
    if gameMap[posx + 1][posy] == 0:
      posx += 1
      gameMap[posx][posy] = -1
      visitCnt += 1
      spinCnt = [0, 0, 0, 0]


print(visitCnt)

# 구현 자체는 어렵지않다.
# 다만 문제를 이해하고 놓치는 부분없이 꼼꼼하게 소스코드로 작성하는 부분이 까다로움
