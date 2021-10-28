while 1:
    stack = []
    check = True
    line = input()
    if line == ".":
        break
    for i in line:
        if i == "(" or i == "[":
            stack.append(i)
        elif i == ")":
            if len(stack) == 0 or stack[-1] != "(":
                check = False
                break
            else:
                stack.pop()
        elif i == "]":
            if len(stack) == 0 or stack[-1] != "[":
                check = False
                break
            else:
                stack.pop()
    if stack:
        check = False
    if check:
        print("yes")
    else:
        print("no")