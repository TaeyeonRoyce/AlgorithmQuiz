def checkPrime(i):
    if i == 2 or i == 3:
        return True
    elif i % 2 == 0:
        return False
    elif i % 3 == 0:
        return False
    for j in range(2, int(i**0.5)+1):
        if i % j == 0:
            return False
    return True

def Boj_Solution(n):
    answer = 0
    if n == 1:
        return 0
    for i in range(2,n + 1):
        if checkPrime(i):
            answer += 1
    return answer
print(Boj_Solution(10))