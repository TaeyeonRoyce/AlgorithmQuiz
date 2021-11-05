def solution(arr):
    answer = []
    minNum = min(arr)
    for i in arr:
        if i == minNum:
            continue
        answer.append(i)
    if not answer:
        return [-1]
    return answer