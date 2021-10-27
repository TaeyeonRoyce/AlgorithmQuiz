userInput = input()
answerList = [-1 for i in range(26)]
for i in range(len(userInput)):
    if answerList[ord(userInput[i]) - 97] == -1:
        answerList[ord(userInput[i]) - 97] = i
print(*answerList)