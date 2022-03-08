def collatz(n):
    k = [n//2,n*3+1]
    return k[n%2]
def Boj_Solution(num):
    answer = 0
    while num != 1:
        num = collatz(num)
        answer += 1
        if answer > 500:
            return -1
    return answer 

print(Boj_Solution(626331))