def solution(K):
    for _ in range(K):
        answer = 0
        N, M = map(int, input().split())
        memo = list(map(int, input().split()))
        cursor = 0
        while 1:
            if cursor >= N-1:
                cursor %= N
            maxNum = max(memo)
            if memo[cursor] >= maxNum:
                answer += 1
                memo[cursor] -= 10
                if cursor == M:
                    break
            cursor += 1
        print(answer)


solution(int(input()))