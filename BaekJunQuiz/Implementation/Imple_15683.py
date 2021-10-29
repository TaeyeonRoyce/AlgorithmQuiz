import copy
N, M = map(int, input().split())
board = []
CCTV_5 = []
CCTVs = []
total = N*M
ans = 0
for i in range(N):
    line = list(map(int, input().split()))
    for j in range(M):
        info = line[j]
        if info == 0:
            pass
        else:
            total -= 1
            if info == 5:
                CCTV_5.append([i,j])
            elif info == 6:
                pass
            else:
                CCTVs.append([info,i,j])
    board.append(line)
def observing(ways, CCTVs, depth, newBoard, c):
    global ans
    preBoard = copy.deepcopy(newBoard)
    camtype = CCTVs[depth][0]
    Y = CCTVs[depth][1]
    X = CCTVs[depth][2]
    for i in ways:
        if i == 1:
            for i in range(1, M - X):
                if newBoard[Y][X+i] == 6:
                    break
                elif newBoard[Y][X+i]  == 0:
                    newBoard[Y][X+i] = 7
                    c += 1
        elif i == 3:    
            for i in range(X):
                if newBoard[Y][X-i-1] == 6:
                    break
                elif newBoard[Y][X-i-1] == 0:
                    newBoard[Y][X-i-1] = 7
                    c += 1
        elif i == 2:
            for i in range(1, N - Y):
                if newBoard[Y+i][X] == 6:
                    break
                elif newBoard[Y+i][X]  == 0:
                    newBoard[Y+i][X] = 7
                    c += 1
        elif i == 0:
            for i in range(Y):
                if newBoard[Y-i-1][X] == 6:
                    break
                elif newBoard[Y-i-1][X] == 0:
                    newBoard[Y-i-1][X] = 7
                    c += 1
    
    if depth == len(CCTVs) - 1:
        if c > ans:
            ans = c
        return preBoard
    elif camtype == 4:
        newBoard = observing([0,1,2],CCTVs,depth+1,newBoard, c)
        newBoard = observing([1,2,3],CCTVs,depth+1,newBoard, c)
        newBoard = observing([2,3,0],CCTVs,depth+1,newBoard, c)
        newBoard = observing([3,0,1],CCTVs,depth+1,newBoard, c)
    elif camtype == 3:
        newBoard = observing([0,1],CCTVs,depth+1,newBoard, c)
        newBoard = observing([1,2],CCTVs,depth+1,newBoard, c)
        newBoard = observing([2,3],CCTVs,depth+1,newBoard, c)
        newBoard = observing([3,0],CCTVs,depth+1,newBoard, c)
    elif camtype == 1:  
        newBoard = observing([0],CCTVs,depth+1,newBoard, c)
        newBoard = observing([1],CCTVs,depth+1,newBoard, c)
        newBoard = observing([2],CCTVs,depth+1,newBoard, c)
        newBoard = observing([3],CCTVs,depth+1,newBoard, c)
    elif camtype == 2:  
        newBoard = observing([0,2],CCTVs,depth+1,newBoard, c)
        newBoard = observing([1,3],CCTVs,depth+1,newBoard, c)
    return preBoard

for i in CCTV_5:
    Y = i[0]
    X = i[1]
    for i in range(1, M - X):
        if board[Y][X+i] == 6:
            break
        elif board[Y][X+i]  == 0:
            board[Y][X+i] = 7
            total -= 1
    for i in range(X):
        if board[Y][X-i-1] == 6:
            break
        elif board[Y][X-i-1] == 0:
            board[Y][X-i-1] = 7
            total -= 1
    for i in range(1, N - Y):
        if board[Y+i][X] == 6:
            break
        elif board[Y+i][X]  == 0:
            board[Y+i][X] = 7
            total -= 1
    for i in range(Y):
        if board[Y-i-1][X] == 6:
            break
        elif board[Y-i-1][X] == 0:
            board[Y-i-1][X] = 7
            total -= 1

if CCTVs:
    if CCTVs[0][0] == 4:
        board = observing([0,1,2], CCTVs, 0, board, 0)
        board = observing([1,2,3], CCTVs, 0, board, 0)
        board = observing([2,3,0], CCTVs, 0, board, 0)
        board = observing([3,0,1], CCTVs, 0, board, 0)
    elif CCTVs[0][0] == 3:
        board = observing([0,1], CCTVs, 0, board, 0)
        board = observing([1,2], CCTVs, 0, board, 0)
        board = observing([2,3], CCTVs, 0, board, 0)
        board = observing([3,0], CCTVs, 0, board, 0)
    elif CCTVs[0][0] == 1:  
        board = observing([0], CCTVs, 0, board, 0)
        board = observing([1], CCTVs, 0, board, 0)
        board = observing([2], CCTVs, 0, board, 0)
        board = observing([3], CCTVs, 0, board, 0)
    elif CCTVs[0][0] == 2:  
        board = observing([0,2], CCTVs, 0, board, 0)
        board = observing([1,3], CCTVs, 0, board, 0)
print(total - ans)







# N, M = map(int, input().split())
# board = []
# def searchObserveRange(Y, X):
#     searchCnt = []
#     #search up
#     cnt = 0
#     for i in range(Y):
#         if board[Y-i-1][X] == 6:
#             break;
#         elif board[Y-i-1][X] == 0:
#             cnt += 1
#     searchCnt.append([0,cnt])
#     #serach right
#     cnt = 0
#     for i in range(1, M - X):
#         if board[Y][X+i] == 6:
#             break;
#         elif board[Y][X+i] == 0:
#             cnt += 1
#     searchCnt.append([1,cnt])
#     #search down
#     cnt = 0
#     for i in range(1,N - Y):
#         if board[Y+i][X] == 6:
#             break;
#         elif board[Y+i][X] == 0:
#             cnt += 1
#     searchCnt.append([2,cnt])
#     #search left
#     cnt = 0
#     for i in range(X):
#         if board[Y][X-i-1] == 6:
#             break;
#         elif board[Y][X-i-1] == 0:
#             cnt += 1
#     searchCnt.append([3,cnt])
#     return searchCnt

# def observeRight(Y, X):
#     for i in range(1, M - X):
#         if board[Y][X+i] == 6:
#             return;
#         elif board[Y][X+i]  == 0:
#             board[Y][X+i] = 7
# def observeLeft(Y, X):
#     for i in range(X):
#         if board[Y][X-i-1] == 6:
#             return;
#         elif board[Y][X-i-1] == 0:
#             board[Y][X-i-1] = 7

# def observeDown(Y, X):
#     for i in range(1, N - Y):
#         if board[Y+i][X] == 6:
#             break;
#         elif board[Y+i][X]  == 0:
#             board[Y+i][X] = 7

# def observeUp(Y, X):
#     for i in range(Y):
#         if board[Y-i-1][X] == 6:
#             break;
#         elif board[Y-i-1][X] == 0:
#             board[Y-i-1][X] = 7


# CCTV_1 = []
# CCTV_2 = []
# CCTV_3 = []
# CCTV_4 = []
# CCTV_5 = []

# for i in range(N):
#     line = list(map(int, input().split()))
#     for j in range(M):
#         if line[j] == 1:
#             CCTV_1.append([i,j])
#         elif line[j] == 2:
#             CCTV_2.append([i,j])
#         elif line[j] == 3:
#             CCTV_3.append([i,j])
#         elif line[j] == 4:
#             CCTV_4.append([i,j])
#         elif line[j] == 5:
#             CCTV_5.append([i,j])
#     board.append(line)

# for i in CCTV_5:
#     y = i[0]
#     x = i[1]
#     observeRight(y,x)
#     observeLeft(y,x)
#     observeDown(y,x)
#     observeUp(y,x)

# for i in CCTV_4:
#     y = i[0]
#     x = i[1]
#     observeRange = searchObserveRange(y,x)
#     observeRange.sort(key=lambda x: (-x[1], x[0]))
#     for j in range(3):
#         searchWay = observeRange[j][0]
#         if searchWay == 0:
#             observeUp(y,x)
#         elif searchWay == 1:
#             observeRight(y,x)
#         elif searchWay == 2:
#             observeDown(y,x)
#         elif searchWay == 3:
#             observeLeft(y,x) 
# for i in CCTV_3:
#     y = i[0]
#     x = i[1]
#     observeRange = searchObserveRange(y,x)
#     searchWay = [3,0]
#     searchSum = observeRange[3][1] + observeRange[0][1]
#     for j in range(3):
#         if observeRange[j][1] + observeRange[j+1][1] >= searchSum:
#             searchSum = observeRange[j][1] + observeRange[j+1][1]
#             searchWay[0] = j
#             searchWay[1] = j + 1
#     for j in searchWay:
#         if j == 0:
#             observeUp(y,x)
#         elif j == 1:
#             observeRight(y,x)
#         elif j == 2:
#             observeDown(y,x)
#         elif j == 3:
#             observeLeft(y,x) 
# for i in CCTV_2:
#     y = i[0]
#     x = i[1]
#     observeRange = searchObserveRange(y,x)
#     searchWay = [0,2]
#     searchSum = observeRange[0][1] + observeRange[2][1]
#     if observeRange[1][1] + observeRange[3][1] >= searchSum:
#         searchWay = [1,3]
#     for j in searchWay:
#         if j == 0:
#             observeUp(y,x)
#         elif j == 1:
#             observeRight(y,x)
#         elif j == 2:
#             observeDown(y,x)
#         elif j == 3:
#             observeLeft(y,x)
# for i in CCTV_1:
#     y = i[0]
#     x = i[1]
#     observeRange = searchObserveRange(y,x)
#     observeRange.sort(key=lambda x: (-x[1], x[0]))
#     searchWay = observeRange[0][0]
#     if searchWay == 0:
#         observeUp(y,x)
#     elif searchWay == 1:
#         observeRight(y,x)
#     elif searchWay == 2:
#         observeDown(y,x)
#     elif searchWay == 3:
#         observeLeft(y,x)

# answer = 0
# for i in board:
#     for j in i:
#         if j == 0:
#             answer += 1
#     print(i)
# print(answer)