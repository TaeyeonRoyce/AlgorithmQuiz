def LCM(a,b):
    if b < a:
        k = b
        b = a
        a = k
    gcd = 1
    for i in range(a):
        division = a - i
        if (a % division == 0 and b % division == 0):
            gcd = division
            break;
    return int(a*b/gcd)

def solution(s):
    for i in range(1,len(s)):
        s[i] = LCM(s[i-1],s[i])
    answer = s[-1]
    return answer



print(solution([2,8,10,24]))
