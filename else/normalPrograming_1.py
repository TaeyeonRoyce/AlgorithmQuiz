A = int(input())
B = int(input())
answer = 0
def Boj_Solution(b):
    if (b % 10 == 1):
        return int(b/10)
    elif (b % 2 == 1):
        return 0
    else:
        return int(b / 2)

while (B > A):
    B = Boj_Solution(B)
    answer += 1
if (A == B):
    print(answer)
else:
    print(-1)

