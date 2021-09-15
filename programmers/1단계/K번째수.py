def solution(array, commands):
    answer = []
    for i in commands:
        newLs = array[i[0]-1:i[1]]
        newLs.sort()
        answer.append(newLs[i[2]-1])
    return answer

