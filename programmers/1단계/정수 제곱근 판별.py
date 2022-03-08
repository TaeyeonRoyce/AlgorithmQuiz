def Boj_Solution(n):
    if n**0.5 % 1 == 0:
        return int(((n**0.5)+1)**2)
    else:
        return -1

print(Boj_Solution(184))