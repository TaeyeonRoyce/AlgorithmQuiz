N = input()

answer = []
k = ""
while len(N) > 0:
    answer.append(N)
    N = N[1:]
answer.sort()
for i in answer:
    print(i)