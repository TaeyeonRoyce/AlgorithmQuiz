import sys

T = int(input())  # Get amount of test cases
alphaList = [sys.stdin.readline().strip() for i in range(T)] # Get a test case
numberDict = {}

for word in alphaList:
    for charIndex in range(len(word)):   
        if word[charIndex] in numberDict:
            numberDict[word[charIndex]] += 10**(len(word) - charIndex - 1) #single letter with chiper
        else:
            numberDict[word[charIndex]] = 10**(len(word) - charIndex - 1)

answerList = []
for values in numberDict.values(): #just take values
    answerList.append(values)

answerList.sort(reverse=True) #sort descending order to multiply 9 to 0
cnt = 9
answer = 0
for a in answerList:
    if cnt == -1: #until cnt == -1
        break
    
    answer += cnt*a
    cnt -= 1
print(answer)