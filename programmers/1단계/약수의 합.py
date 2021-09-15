def solution(n):
    answer = 0
    for i in range(1,int((n**0.5))+1):
        if n % i == 0:
            answer = answer + i + (n//i)
    if n**0.5 == int(n**0.5):
        answer -= int(n**0.5)
    return answer

print(solution(9))