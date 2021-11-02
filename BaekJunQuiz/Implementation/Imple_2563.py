N = int(input())

board = [[False]*100 for _ in range(100)]
answer = 0
for _ in range(N):
    X,Y = map(int, input().split())
    for i in range(10):
        for j in range(10):
            if board[100-Y-j][X+i] == False:
                answer +=1
            board[100-Y-j][X+i] = True
print(answer)