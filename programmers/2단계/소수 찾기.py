from itertools import permutations

def primeCheck(n):
    if n == 1 or n == 0:
        return False
    for i in range(2,int((n**0.5))+1):
        if n % i == 0:
            return False
    return True

def sumNums(n):
    k = 0
    for i in range(len(n)):
        k += n[i]*(10**i)
    return k

def Boj_Solution(numbers):
    newList = []
    for i in range(len(numbers)):
        newList.append(int(numbers[i]))
    overlapList = []
    cnt = 0
    for i in range(1,len(newList)+1):
        orderdList = list(permutations(newList,i))
        for j in orderdList:
            j = list(j)
            k = sumNums(j)
            if k not in overlapList:
                overlapList.append(k)
    for i in overlapList:
        if primeCheck(i):
            cnt += 1
    return cnt

print(Boj_Solution("17"))