def Boj_Solution(arr, divisor):
    answer = []
    for i in arr:
        if i % divisor == 0:
            answer.append(i)
    if len(answer) == 0:
        return [-1]
    else:
        return sorted(answer)
    

print(Boj_Solution([5, 9, 7, 10],5))