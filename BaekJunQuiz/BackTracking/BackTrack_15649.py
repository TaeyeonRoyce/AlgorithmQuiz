N, M = map(int, input().split())

previousList= []

def Boj_Solution(previousList, depth, N, M):
    if depth == M:
        print(*previousList,sep=" ")
        return
    for i in range(1,N+1):
        if i in previousList:
            continue
        else:
            previousList.append(i)
            Boj_Solution(previousList, depth + 1, N, M)
            previousList.pop()

Boj_Solution(previousList, 0, N, M)
