
def Boj_Solution(board, moves):
    answer = 0
    basket = []
    check = False
    for i in moves:
        n = 0
        while board[n][i-1] == 0:
            n += 1
            if n == len(board[0])-1 and board[n][i-1] == 0:
                check = True
                break
        if check:
            check = False
            pass
        else:
            basket.append(board[n][i-1])
            board[n][i-1] = 0
    cnt = -1
    while 1:
        cnt += 1
        if cnt >= len(basket)-1:
            break
        elif basket[cnt] == basket[cnt+1]:
            answer += 2
            basket = basket[:cnt] + basket[cnt+2:]
            cnt = -1
    
    return answer

print(Boj_Solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]],[1,4,5,3,5]))