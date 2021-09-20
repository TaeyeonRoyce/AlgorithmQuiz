N = int(input())

def solution(n):
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
    if solution(userInput):
        print("YES")
    else:
        print("NO")