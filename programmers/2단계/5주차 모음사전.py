def Boj_Solution(word):
    answer = 0
    motherList = ["A","E","I","O","U"]
    letterGap = 0
    for i in range(5):
        letterGap += 5**i
    for j in range(len(word)):
        for i in range(len(motherList)):
            if word[j] == motherList[i]:
                answer += 1
                break
            answer += letterGap
        letterGap -= 5**(4-j)
    return answer

print(Boj_Solution("I"))