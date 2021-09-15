def solution(d, budget):
    d.sort()
    sum = 0
    for i in range(len(d)):
        sum += d[i]
        if i == len(d)-1 and sum <= budget:
            return len(d)
        elif sum > budget:
            return i
        elif sum == budget:
            return i+1

print(solution([4],1))