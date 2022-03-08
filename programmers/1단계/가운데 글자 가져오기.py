def Boj_Solution(s):
    charLs = list(s)
    length = len(charLs)
    answer = charLs[int(length/2)]
    if length % 2 == 0:
        answer = [charLs[int(length/2)-1], charLs[int(length/2)]]
        answer = (''.join(answer))
    return answer
print(Boj_Solution('asdfdsa'))