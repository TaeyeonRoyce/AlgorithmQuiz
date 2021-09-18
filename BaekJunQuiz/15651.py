N, M = map(int, input().split())

previousList= []

def solution(previousList, depth, N, M):
    if depth == M:
        print(*previousList,sep=" ")
        return
    for i in range(1,N+1):
        previousList.append(i)
        solution(previousList, depth + 1, N, M)
        previousList.pop()

solution(previousList, 0, N, M)
