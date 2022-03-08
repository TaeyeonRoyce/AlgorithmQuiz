


# def Boj_Solution(n):
#     ans = []
#     if n < 3:
#         return n
#     if n == 3:
#         return 4
#     k , i , sizeNum = 1 , 1 , 0
#     while n >= k:
#         k += 3**i
#         i += 1
#         sizeNum += 1
#     k -= 3**sizeNum
#     for j in range(sizeNum):    
#         numberLine = n - k
#         if numberLine // 3**(sizeNum-j-1) == 0:
#             ans.append('1')
#         elif numberLine // 3**(sizeNum-j-1) == 1:
#             ans.append('2')
#         elif numberLine // 3**(sizeNum-j-1) == 2:
#             ans.append('4')
#         k += 3**(sizeNum - (j + 1))
#     ans = (''.join(ans))
#     return ans


# print(Boj_Solution(24))


def Boj_Solution(n):
    answer = ''
    while n > 0:
        n -= 1
        answer = '124'[n%3] + answer
        n //= 3
    return answer
print(Boj_Solution(16))