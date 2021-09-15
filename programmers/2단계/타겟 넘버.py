def deeping(numbers, cnt,depth,target,sum):
    if depth == len(numbers)-1:
        if target == sum:
            return cnt + 1
        else:
            return cnt
    else:
        cnt = deeping(numbers,cnt,depth + 1,target,sum + numbers[depth+1])
        cnt = deeping(numbers,cnt,depth + 1,target,sum - numbers[depth+1])
    return cnt


def solution(numbers, target):
    answer = deeping(numbers,0,0,target,numbers[0]) + deeping(numbers,0,0,target,numbers[0]*(-1))
    return answer
# print(deeping([1,1,1,1,1],0,0,3,1))
# print(deeping([1,1,1,1,1],0,0,3,-1))
print(solution([1, 2, 1, 2], 6))