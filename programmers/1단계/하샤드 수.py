def hassad(n):
    sumN = 0
    while n > 0:
        sumN += n %10
        n //= 10
    return sumN
def Boj_Solution(x):
    print(hassad(x))
    return True if x % hassad(x) == 0 else False  

print(Boj_Solution(12))