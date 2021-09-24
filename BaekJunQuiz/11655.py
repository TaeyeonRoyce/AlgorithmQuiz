userInput = input()
answer = []
for i in userInput:
    if i.isupper():
        char = ord(i) + 13
        if ord(i) + 13 > 90:
            char = ord(i) + 13 - 26
        answer.append(chr(char))
    elif i.islower():
        char = ord(i) + 13
        if ord(i) + 13 > 122:
            char = ord(i) + 13 - 26
        answer.append(chr(char))
    else:
        answer.append(i)
print("".join(answer))