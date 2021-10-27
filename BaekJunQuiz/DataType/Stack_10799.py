userInput = input()
userInput += "@"
pipeRange = 0
pipeCnt = 0
cursor = 0
while cursor < len(userInput) - 1:
    index = userInput[cursor]
    nextIndex = userInput[cursor + 1]
    if index == "(" and nextIndex == ")":
        pipeCnt += pipeRange
        cursor += 1
    elif index == "(":
        pipeRange += 1
    elif index == ")":
        pipeRange -= 1
        pipeCnt += 1
    cursor += 1
print(pipeCnt)