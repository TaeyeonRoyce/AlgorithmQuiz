def Boj_Solution(arr):
    answer = []
    answer.append(arr[0])
    for i in range(1,len(arr)):
        if arr[i-1] == arr[i]:
            continue
        else:
            answer.append(arr[i])

    return answer


print(Boj_Solution([1,1,3,3,0,1,1]))