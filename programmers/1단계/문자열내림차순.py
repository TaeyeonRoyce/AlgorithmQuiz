def solution(s):
    answer = list(s)
    answer.sort()
    answer.reverse()
    answer = (''.join(answer))
    return answer
print(solution('Zbcdefg'))