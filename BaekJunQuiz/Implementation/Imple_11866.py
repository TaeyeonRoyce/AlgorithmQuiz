def Boj_Solution(N,K):
    memo = list(range(1,N + 1))
    cursor = 0
    cnt = 0
    answer = []
    while len(answer) < N:
        if cnt == K - 1:
            answer.append(memo[cursor])
            cnt = 0
        else:
            memo.append(memo[cursor])
            cnt += 1
        cursor += 1
    return answer


N, K = map(int, input().split())
answer = Boj_Solution(N,K)
print("<",end="")
for i in answer:
    if i == answer[-1]:
        print(i,end="")
        break
    print(i, end=", ")

print(">",end="")