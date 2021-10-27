N = int(input())
for _ in range(N):
    userInput = input().split()
    newList = []
    for i in userInput:
        newI = list(i)
        newI.reverse()
        reversedWord = ("").join(newI)
        newList.append(reversedWord)
    result = (" ").join(newList)
    print(result)