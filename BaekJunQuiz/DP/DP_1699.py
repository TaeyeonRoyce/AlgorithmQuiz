#제곱수의 합

N = int(input())
memo1 = [x**2 for x in range(1,int(N**0.5)+1)]
answer = 0
memo2 = [0]*(N+1)
memo2[1] = 1

for i in range(2,N+1):
    memo2[i] = i
    for j in memo1:
        if j > i:
            break
        elif memo2[i] > memo2[i-j] + 1:
            memo2[i] = memo2[i-j] + 1

print(memo2[-1])