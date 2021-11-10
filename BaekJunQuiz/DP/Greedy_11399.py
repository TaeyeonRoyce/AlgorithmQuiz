N = int(input())
timeLs = list(map(int, input().split()))
timeLs.sort()
answer = 0
lsLength = len(timeLs)
for i in range(lsLength):
    number = timeLs[i]
    answer += number*(lsLength - i)
print(answer)
