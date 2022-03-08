def Boj_Solution(s):
    answer = list(s)
    answer.sort()
    answer.reverse()
    answer = (''.join(answer))
    return answer
print(Boj_Solution('Zbcdefg'))