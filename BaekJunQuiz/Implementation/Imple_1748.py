N = int(input())
#  220 = 9 + 2*90 + 3*121 / 9 + 180 + 63
scale = 10
digit = 1
answer = 0
while N / scale >= 1:
    digit += 1
    scale *= 10
if digit == 1:
    answer = N
else:
    for i in range(1, digit + 1):
        if i == digit:
            answer += (N-10**(i-1) + 1)*i
        else:
            answer += i*9*10**(i-1)
print(answer)