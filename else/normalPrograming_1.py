A = int(input())
B = int(input())
answer = 0
def solution(b):
    if (b % 10 == 1):
        return int(b/10)
    elif (b % 2 == 1):
        return 0
    else:
        return int(b / 2)

while (B > A):
    B = solution(B)
    answer += 1
if (A == B):
    print(answer)
else:
    print(-1)

