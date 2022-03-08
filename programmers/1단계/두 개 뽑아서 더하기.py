import itertools

def Boj_Solution(numbers):
    answer = []
    comList = list((itertools.combinations(numbers,2)))
    for i in range(len(comList)):
        k = sum(comList[i])
        answer.append(k)
    return sorted(list(set(answer)))


print(Boj_Solution([5,0,2,7]))