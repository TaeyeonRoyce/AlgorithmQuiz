def solution(dartResult):
    numLs = ['0','1','2','3','4','5','6','7','8','9']
    chances = []
    cnt = 0
    for i in range(len(dartResult)):
        if dartResult[i] == '1' and dartResult[i+1] == '0':
            cnt += 1
            continue
        elif i == len(dartResult)-1:
            chances.append(dartResult[i-cnt:i+1])
        elif dartResult[i+1] in numLs:
            chances.append(dartResult[i-cnt:i+1])
            cnt = -1
        cnt += 1
    answer = []
    for i in range(len(chances)):
        k = 1
        if 'D' in chances[i]:
            k = 2
        elif 'T' in chances[i]:
            k = 3
        if '10' in chances[i]:
            answer.append(10**k)
        else:
            answer.append(int(chances[i][0])**k)
    for i in range(len(chances)):
        if '#' in chances[i]:
            answer[i] *= (-1)
        elif '*' in chances[i]:
            if i == 0:
                answer[0] *= 2
            else:
                answer[i] *= 2
                answer[i-1] *= 2
    return sum(answer)

print(solution('1S2D*3T'))