def solution(answers):
    answer = []
    loops = len(answers)//5
    studentOne = [1, 2, 3, 4, 5] * (loops + 1)
    studentTwo = [2, 1, 2, 3, 2, 4, 2, 5] * (loops + 1)
    studentThree = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * (loops + 1)
    scores = [0,0,0]
    for i in range(len(answers)):
        if answers[i] == studentOne[i]:
            scores[0] += 1
        if answers[i] == studentTwo[i]:
            scores[1] += 1
        if answers[i] == studentThree[i]:
            scores[2] += 1
    maximum = max(scores)
    for i in range(3):
        if maximum == scores[i]:
            answer.append(i+1)

    return answer

print(solution([1,3,2,4,2]))