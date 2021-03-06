def Boj_Solution(K):
    stack = []
    for _ in range(K):
        N = int(input())
        if len(stack) > 0 and N == 0:
            stack.pop()
        else:
            stack.append(N)
    return sum(stack)

print(Boj_Solution(int(input())))