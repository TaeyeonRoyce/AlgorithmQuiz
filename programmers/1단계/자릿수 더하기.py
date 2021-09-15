# def sumNum(a,sum):
#     if a < 10:
#         return sum
#     k = a % 10
#     sum += k
#     sumNum(int(a/10),sum)

# def solution(n):
#     answer = 0
#     answer = sumNum(n,answer)
#     return answer

# print(solution(123))
def solution(n):
    answer = 0
    while n > 0:
        answer += (n % 10)
        n = n//10
    return answer
print(solution(987))