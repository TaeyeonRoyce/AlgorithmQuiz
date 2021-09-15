
def solution(n,a,b):
    if b < a:
        k = b
        b = a
        a = k
    cnt = 0
    while n >= 1:
        if a <= n and b > n:
            break
        elif a > n:
            a -= n
            b -= n
        else:
            n /= 2
    n *= 2
    while n > 1:
        cnt += 1
        n /= 2

    return cnt

# def solution(n,a,b):
#     answer = 0
#     while a != b:
#         answer += 1
#         a, b = (a+1)//2, (b+1)//2

#     return answer
print(solution(8,1,2))



