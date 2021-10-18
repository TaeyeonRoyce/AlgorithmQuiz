def solution(N):
    newN = []
    for i in range(len(N)):
        newN.append(int(N[i]))
    answer_1 = 0
    answer_2 = 0
    for i in range(0,10):
        if i == 6 or i == 9:
            answer_2 += newN.count(i)
        elif newN.count(i) > answer_1:
            answer_1 = newN.count(i)
    return max(answer_1, (answer_2+1) // 2)
N = input()
print(solution(N))
