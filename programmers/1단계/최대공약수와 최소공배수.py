def gcd(n,m):
    if m == 0:
        return n
    if n % m == 0:
        return m
    else:
        return gcd(m, n % m)


def Boj_Solution(n, m):
    answer = []
    answer.append(gcd(n,m))
    answer.append(n*m/gcd(n,m))

    return answer