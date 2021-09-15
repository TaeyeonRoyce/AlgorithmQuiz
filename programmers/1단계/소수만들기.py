def sumPrime(a,b,c):
    num = a + b + c
    for i in range(2,num):
        if num % i == 0:
            return False
    return True

def solution(nums):
    answer = 0
    k = len(nums)
    for i in range(k-2):
        for j in range(i+1,k-1):
            for q in range(j+1,k):
                sumOfNums = sumPrime(nums[i],nums[j],nums[q])
                if sumOfNums:
                    answer += 1
    return answer

print(solution([1,2,3,4]))