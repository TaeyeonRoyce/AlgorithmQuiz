userInput = input()
tag = ""
splitedList = []
for i in range(len(userInput)):
    char = userInput[i]
    if char == "<" and tag != "":
        splitedList.append(tag.split())
        tag = ""
        tag += char
    elif char == ">":
        tag += char
        splitedList.append(tag)
        tag = ""
    else:
        tag += char
    if i == len(userInput) - 1 and tag != "":
        splitedList.append(tag.split())

answer = ""
for i in splitedList:
    if "<" in i:
        answer += i
    else:
        for j in range(len(i)):
            answer += "".join(list(reversed(i[j])))
            if j != len(i) - 1:
                answer += " "
print(answer)