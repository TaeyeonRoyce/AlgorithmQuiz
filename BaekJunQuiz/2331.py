N = int(input())
answerN = N
digit = len(str(N))

k = 0
for i in range(digit - 1):
    if i == 0:
        k += 18
    else:
        k += (10**(i)+1)*9

answerList = []

for i in range(digit,0,-1):  #digit ~ 1
    if i == 1:
        answerList.append(str(int(N/2)))
    else:
        num = 0
        if N == 17:
            answerList.append("1")
            num = 1
        else:
            while num*(10**(i-1)+1) < N - k:
                num += 1
            answerList.append(str(num))
        N -= num*(10**(i-1)+1)
        k -= (10**(i-2)+1)*9

answer = int(("").join(answerList))
sum = 0
for i in answerList:
    sum += int(i)
if sum + answer == answerN:
    print(answer)
else:
    print(0)
