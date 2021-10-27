#test case
#50+21-31+39-21-31+30+209+12+31

userInput = list(input().split("-"))  # "-" 단위로 계산식 받기
newList = []
for i in userInput:                   #userInput의 숫자합 구하기
    sum = 0                           
    numbers = i.split("+")            #문자열로 되어있는 userInput의 숫자합 더하기
    for j in numbers:
        sum += int(j)
    newList.append(sum)

answer = 2*newList[0]
for i in newList:
    answer -= i
print(userInput)
print(newList)
print(answer)