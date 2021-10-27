N,K = map(int, input().split())
answerList = []
circleList = list(range(1,N + 1))
cursor = K - 1
while len(circleList) != 0:
    if cursor >= len(circleList):
        cursor -= len(circleList)
    else:
        answerList.append(str(circleList.pop(cursor)))
        cursor += K - 1
print("<", ", ".join(answerList), ">", sep='')
    
