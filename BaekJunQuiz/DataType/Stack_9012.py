N = int(input())

def Boj_Solution(n):
    cnt = 0
    if len(n) % 2 ==1 :
        return False
    for i in n:
        if i == "(":
            cnt += 1
        else:
            cnt -= 1
        if cnt < 0:
            return False
    if cnt > 0:
        return False
    return True


for _ in range(N):
    userInput = input()
    if Boj_Solution(userInput):
        print("YES")
    else:
        print("NO")