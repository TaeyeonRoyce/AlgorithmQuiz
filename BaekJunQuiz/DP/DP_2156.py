N = int(input())
wines = [0]
for _ in range(N):
    wines.append(int(input()))
memo = [0]
memo.append(wines[1])
if N == 1:
    print(wines[1])
elif N == 2:
    print(wines[1]+wines[2])
else:
    memo.append(wines[1]+wines[2])
    for i in range(3,N+1):
        memo.append(max(memo[i-1], memo[i-3] + wines[i-1] + wines[i], memo[i-2] + wines[i]))
    print(memo[-1])