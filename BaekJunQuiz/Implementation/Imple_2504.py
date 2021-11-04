bracket = input()
stack = []
isTrue = True
for i in bracket:
    if i == "(":
        stack.append(i)
    elif i == "[":
        stack.append(i)
    elif i == ")":
        if len(stack) == 0 or stack[-1] == "[":
            isTrue = False
            break
        stack.pop()
    elif i == "]":
        if len(stack) == 0 or stack[-1] == "(":
            isTrue = False
            break
        stack.pop()
if not isTrue or len(stack) > 0 :
    print(0)
else:
    for i in bracket:
        if i == "(" or i == "[":
            stack.append(i)
        elif i == ")":
            if stack[-1] == "(":
                stack.pop()
                if stack and stack[-1] != "(" and stack[-1] != "[":
                    stack[-1] += 2
                else:
                    stack.append(2)
            elif stack[-1] != "(" and stack[-1] != "[":
                num = stack[-1]
                stack.pop()
                while stack and stack[-1] != "(" and stack[-1] != "[":
                    num += stack[-1]
                    stack.pop()
                num *= 2
                if stack:
                    stack.pop()
                stack.append(num)
        elif i == "]":
            if stack[-1] == "[":
                stack.pop()
                if stack and stack[-1] != "(" and stack[-1] != "[":
                    stack[-1] += 3
                else:
                    stack.append(3)
            elif stack[-1] != "(" and stack[-1] != "[":
                num = stack[-1]
                stack.pop()
                while stack and stack[-1] != "(" and stack[-1] != "[":
                    num += stack[-1]
                    stack.pop()
                num *= 3
                if stack:
                    stack.pop()
                stack.append(num)
    print(sum(stack))