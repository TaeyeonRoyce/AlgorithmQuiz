while True:
    try:
        N = input()
        answerList = [0, 0, 0, 0]
        for i in N:
            charToAscii = ord(i)
            if i.islower():
                answerList[0] += 1
            elif i.isupper():
                answerList[1] += 1
            elif i.isdigit():
                answerList[2] += 1
            else:
                answerList[3] += 1
    except EOFError:
        break

    print(*answerList)