def solution(N, stages):
    storage = []
    answer = []
    cpyStorage = []
    totalLen = len(stages)
    for i in range(1,N+1):
        cnt = stages.count(i)    
        if totalLen <= 0:
            storage.append(0)
            cpyStorage.append(0)
        else:
            storage.append(cnt/totalLen)
            cpyStorage.append(cnt/totalLen)
            totalLen -= cnt
    storage.sort()
    storage.reverse()
    for i in storage:
        answer.append(cpyStorage.index(i)+1)
        cpyStorage[cpyStorage.index(i)] += 1
    return answer

print(solution(4,[1,2,1,3,1]))