def solution(new_id):
    answer = ''
    new_id = new_id.lower()
    exList = ['1','2','3','4','5','6','7','8','9','0','-','_','.']
    for i in new_id:
        if i in exList or i.isalpha():
            answer += i
    for i in range(2,len(answer)-1):
        dots = '.'*i
        while dots in answer:
            answer = answer.replace(dots,'.')
    if answer[0] == '.':
        answer = answer[1:]
    if len(answer) == 0:
        answer += 'a'
    if len(answer) >= 16:
        answer = answer[:15]
    if answer[-1] == '.':
            answer = answer[:-1]
    if len(answer) <= 2:
        while len(answer) < 3:
            answer += answer[-1]
    
    return answer