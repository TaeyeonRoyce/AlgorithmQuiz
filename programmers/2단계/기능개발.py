def developFunc(progresses, speeds):
    days = 0
    cnt = 0
    while 1:
        days += 1
        if progresses[0] + speeds[0]*days >= 100:
            break;
    processed = []
    for i in range(len(progresses)):
        processed.append(progresses[i] + speeds[i]*days)
    for i in processed:
        if i < 100:
            break;
        cnt += 1
    return cnt

def solution(progresses, speeds):
    answer = []
    while len(progresses) != 0:
        cnt = developFunc(progresses, speeds)
        for _ in range(cnt):
            del progresses[0]
            del speeds[0]
        answer.append(cnt)
    return answer
print(solution([95, 90, 99, 99, 80, 99],[1, 1, 1, 1, 1, 1]))