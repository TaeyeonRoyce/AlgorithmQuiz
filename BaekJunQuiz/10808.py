userInput = input()
answerList = [0 for i in range(26)]
for i in userInput:
    answerList[ord(i) - 97] += 1
print(*answerList)