#제곱수의 합

N = int(input())
memo = [x**2 for x in range(1,int(N**0.5)+1)]
answer = 0
while N != 0:
    if N - memo[-1] < 0:
        memo.pop()
        continue
    N -= memo[-1]
    answer +=1
print(answer)