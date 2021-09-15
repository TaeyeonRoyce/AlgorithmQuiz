def convertBin(num , n):
    ans = ''
    while num > 0:
            ans = '01'[num%2] + ans
            num //= 2
    if len(ans) < n:
        ans = '0'*(n-len(ans)) + ans
    return ans

def solution(n, arr1, arr2):
    newArr1 = []
    newArr2 = []
    answer = []
    for i in range(n):
        newArr1.append(convertBin(arr1[i],n))
        newArr2.append(convertBin(arr2[i],n))
    for i in range(n):
        typeOfBlock = ''
        for j in range(n):
            if newArr1[i][j] == '0' and newArr2[i][j] == '0':
                if typeOfBlock[-1] == " ":
                    pass
                else:
                    typeOfBlock = typeOfBlock + " " 
            else:
                typeOfBlock = typeOfBlock + "#"
        answer.append(typeOfBlock)
    return answer


print(solution(5,[9, 20, 28, 18, 11],[30, 1, 21, 17, 28]))