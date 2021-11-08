N = int(input())
words = []
for i in range(N):
    words.append(list(input()))

answer = 0


def checkLine(word):
    maxCnt = 0
    cnt = 1
    for i in range(1,len(word)):
        currentColor = word[i]
        cmpColor = word[i-1]
        if currentColor == cmpColor:
            cnt += 1
        else:
            if cnt > maxCnt:
                maxCnt = cnt
            cnt = 1
    if cnt > maxCnt:
        maxCnt = cnt
        cnt = 1 
    return maxCnt

def checkBoardAfterRow(a,b):
    newWord = ""
    cntARMax = 0
    for i in range(N):
        newWord += words[a][i]
        cntAR = checkLine(newWord)
        if cntAR > cntARMax:
            cntARMax = cntAR
    for i in range(2):
        newWord = ""
        for j in range(N):
            newWord += words[j][b+i]
            cntAR = checkLine(newWord)
            if cntAR > cntARMax:
                cntARMax = cntAR
    return cntARMax

def checkBoardAfterCol(a,b):
    newWord = ""
    cntACMax = 0
    for i in range(N):
        newWord += words[i][a]
        cntAC = checkLine(newWord)
        if cntAC > cntACMax:
            cntACMax = cntAC
    for i in range(2):
        newWord = ""
        for j in range(N):
            newWord += words[b+i][j]
            cntAC = checkLine(newWord)
            if cntAC > cntACMax:
                cntACMax = cntAC
    return cntACMax
for i in range(N):
    for j in range(N-1):
        tmp = words[i][j]
        tmp2 = words[i][j+1]
        words[i][j+1] = tmp
        words[i][j] = tmp2
        cnt = checkBoardAfterRow(i,j)
        if cnt > answer:
            answer = cnt
        words[i][j] = tmp
        words[i][j+1] = tmp2
for i in range(N):
    for j in range(N-1):
        tmp = words[j][i]
        tmp2 = words[j+1][i]
        words[j+1][i] = tmp
        words[j][i] = tmp2
        cnt = checkBoardAfterCol(i,j)
        if cnt > answer:
            answer = cnt
        words[j][i] = tmp
        words[j+1][i] = tmp2

print(answer)