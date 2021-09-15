

def solution(n, lost, reserve):
    newLs = []
    lost.sort()
    reserve.sort()
    for i in range(1,reserve[-1]+1):
        if i in lost and i in reserve:
            lost.remove(i)
            reserve.remove(i)
    for i in lost:
        if i-1 in reserve and i-1 not in newLs:
            newLs.append(i-1)
        elif i + 1 in reserve and i + 1 not in newLs:
            newLs.append(i+1)
    return n - len(lost) + len(newLs)

print(solution(8, [1, 2, 4, 6], [1, 2, 4, 6]))
