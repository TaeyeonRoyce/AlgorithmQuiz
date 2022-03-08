

def Boj_Solution(participant, completion):
    A = set(participant)
    B = set(completion)
    answer = list(A-B)
    if len(answer) == 0:
        participant.sort()
        completion.sort()
        for i in range(len(participant)):
            if participant[i] != completion[i]:
                return participant[i]
    else:
        return answer[0]
print(Boj_Solution(["mislav", "stanko", "mislav", "ana"],["mislav", "ana","stanko"]))