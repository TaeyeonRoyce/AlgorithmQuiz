def solution(n):
    answer = ''
    newList = []
    while n > 0:
        newList.append(n%3)
        n //= 3
    decimal = 0
    len_newList = len(newList)
    for i in range(len_newList):
        decimal += 3**(len_newList-i-1)*newList[i]
    return decimal

print(solution(45))
