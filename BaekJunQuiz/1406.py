import sys

userInput = list(input())
stack = []
N = int(input())

for i in range(N):
    userEditCommand = sys.stdin.readline().strip()
    if userEditCommand == "L":
        if len(userInput) == 0:
            continue
        else:
            stack.append(userInput.pop())
    elif userEditCommand == "D":
        if len(stack) == 0:
            continue
        else:
            userInput.append(stack.pop())
    elif userEditCommand == "B":
        if len(userInput) == 0:
                continue
        else:
            userInput.pop()
    else:
        pushLetter = userEditCommand.split()[-1]
        userInput.append(pushLetter)

print("".join(userInput), end="")
print("".join(list(reversed(stack))))
