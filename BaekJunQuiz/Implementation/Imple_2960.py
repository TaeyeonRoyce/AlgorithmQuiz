N, K = map(int, input().split())
board = [False]*(N+1)
board[0] = True
board[1] = True
process = 0
cursor = 2
while 1:
    isBreak = False
    for i in range(len(board)):
        if board[i] == False:
            cursor = i    
            break
    for i in range(1,N):
        if cursor*i >= len(board):
            break
        if board[cursor*i] == False:
            process += 1
        board[cursor*i] = True
        if process == K:
            print(cursor*i)
            isBreak = True
            break
    if isBreak:
        break
    
    
